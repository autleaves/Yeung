;
;   The Calculator, Main Algorithm
;
            LEA     R6, StackBase
            ADD     R6, R6, #1

NewCommand  LEA     R0, PromptMsg
            PUTS
            GETC
            OUT
;
;   Check the command
;
TestX       LD      R1, NegX
            ADD     R1, R1, R0
            BRnp    TestC
            HALT
;
TestC       LD      R1, NegC
            ADD     R1, R1, R0
            BRnp    TestAdd
            JSR	    OpClear
            BRnzp   NewCommand
;
TestAdd     LD      R1, NegPlus
            ADD     R1, R1, R0
            BRnp    TestMult
            JSR     OpAdd
            BRnzp   NewCommand
;
TestMult    LD      R1, NegMult
            ADD     R1, R1, R0
            BRnp    TestMinus
            JSR     OpMult
            BRnzp   NewCommand
;
TestMinus   LD      R1, NegMinus
            ADD     R1, R1, R0
            BRnp    TestD
            JSR     OpNeg
            BRnzp   NewCommand
;
TestD       LD      R1, NegD
            ADD     R1, R1, R0
            BRnp    EnterNumber
            JSR     OpDisplay
            BRnzp   NewCommand
;
;   Then we must be entering an integer
;
EnterNumber JSR     PushValue
            BRnzp   NewCommand
;
PromptMsg   .FILL	x000A
            .STRINGZ	"Enter a command:"
NegX        .FILL	xFFA8
NegC        .FILL	xFFBD
NegPlus     .FILL	xFFD5
NegMinus    .FILL	xFFD3
NegMult     .FILL	xFFD6
NegD        .FILL	xFFBC

;Globals
StackMax    .BLKW	#9
StackBase   .BLKW	#1
ASCIIBUFF   .BLKW	#4
            .FILL	x0000   ;ASCIIBUFF sentinel
;
;
;
PushValue       ST      R0, PushValue_Save0
                ST      R1, PushValue_Save1
                ST      R2, PushValue_Save2
                ST      R7, PushValue_Save7
                LD      R1, PushValue_ASCIIBUFF     ;这里虽然使用的是LD指令，但是因为PushValue_ASCIIBUFF实际存储的值是ASCIIBUFF的首地址
                LD      R2, MaxDigits               ;所以R1是指向ASCIIBUFF的指针
;
ValueLoop       ADD     R3, R0, x-0A        ;判断输入结束
                BRz     GoodInput
                ADD     R2, R2, #0          ;判断是否输入超过3个数字，R2初始值=3，每执行一次ValueLoop，第21行就将R2减1
                BRz     TooLargeInput
                LD      R3, NegASCII0
                ADD     R3, R0, R3
                BRn     NotInteger
                LD      R3, NegASCII9
                ADD     R3, R0, R3
                BRp     NotInteger          ;判断该字符是否是数字，数字的ASCII码值在x30～x39
                ADD     R2, R2, #-1
                STR     R0, R1, #0
                ADD     R1, R1, #1          ;将键盘输入的一串数字存入到ASCIIBUFF中，ValueLoop循环结束后，R1指向ASCIIBUFF存入完数字后面的那个地址
                GETC
                OUT
                BRnzp   ValueLoop
;    
GoodInput       LD      R2, PushValue_ASCIIBUFF
                NOT     R2, R2
                ADD     R2, R2, #1
                ADD     R1, R1, R2          ;判断输入了几个数字, 该number存放在R1，在调用ASCIItoBinary时，该子程序会使用这个R1的值
                BRz     NoDigit
                JSR	    ASCIItoBinary
                JSR	    PUSH
                BRnzp   PushValue_Done
;
NoDigit         LEA     R0, NoDigitMsg
                PUTS
                BRnzp   PushValue_Done
;            
NotInteger      GETC
                OUT
                ADD     R3, R0, x-0A
                BRnp    NotInteger
                LEA     R0, NotIntegerMsg
                PUTS
                BRnzp   PushValue_Done
;                
TooLargeInput   GETC
                OUT
                ADD     R3, R0, x-0A
                BRnp    TooLargeInput
                LEA     R0, TooManyDigits
                PUTS                    ;这里没有像上面那样结尾写BRnzp PushValue_Done，是因为它后面就是这个PushValue_Done
;
PushValue_Done  LD      R0, PushValue_Save0
                LD      R1, PushValue_Save1
                LD      R2, PushValue_Save2
                LD      R7, PushValue_Save7
                RET
TooManyDigits       .FILL	x000A
                    .STRINGZ	"Too many digits"
NoDigitMsg          .FILL	x000A                
                    .STRINGZ	"No number entered"
NotIntegerMsg       .FILL	x000A                
                    .STRINGZ	"Not an integer"
MaxDigits           .FILL	x0003
NegASCII0           .FILL	x-30                
NegASCII9           .FILL	x-39                
PushValue_ASCIIBUFF .FILL	ASCIIBUFF
PushValue_Save0     .BLKW	#1
PushValue_Save1     .BLKW	#1
PushValue_Save2     .BLKW	#1
PushValue_Save7     .BLKW	#1
;   This subroutine calls BinarytoASCII to convert the 2's complement
;   number on the top of the stack into an ASCII character string. and
;   then calls PUTS to display that number on the screen.
OpDisplay       ST  R0, OpDisplay_Save0
                ST  R5, OpDisplay_Save5
                ST  R7, OpDisplay_Save7
                JSR POP
                ADD R5, R5, #0
                BRp OpDisplay_DONE
                JSR BinarytoASCII
                LD  R0, NewlineChar
                OUT
                LD  R0, OpDisplay_ASCIIBUFF
                PUTS
                ADD R6, R6, #-1
;  
OpDisplay_DONE  LD  R0, OpDisplay_Save0
                LD  R5, OpDisplay_Save5
                LD  R7, OpDisplay_Save7
                RET
NewlineChar         .FILL	x000A
OpDisplay_ASCIIBUFF .FILL	ASCIIBUFF
OpDisplay_Save0     .BLKW	#1
OpDisplay_Save5     .BLKW	#1
OpDisplay_Save7     .BLKW	#1
;
;
OpClear         LEA     R6, OpClear_StackBase
                ADD     R6, R6, #1
                RET
OpClear_StackBase   .FILL	StackBase
;   Subroutine to pop the top two elements from the stack,
;   add them, and push the sum onto the stack. 
;   R6 is the stack pointer.
OpAdd       ST      R0, OpAdd_Save0
            ST      R1, OpAdd_Save1
            ST      R5, OpAdd_Save5
            ST      R7, OpAdd_Save7
            JSR     POP             ;从栈中第1次弹出，其中POP子程序会使用R0存放弹出的数据，R6是栈指针。
                                    ;R5存放弹出是否成功的状态码，0代表成功，1代表出错
            ADD     R5, R5, #0      ;检查POP操作时是否成功
            BRp     OpAdd_Exit            
            ADD     R1, R0, #0      ;把POP弹出到R0的数据拷贝到R1
            JSR     POP             ;从栈中第2次弹出
            ADD     R5, R5, #0
            BRp     OpAdd_Restore1        ;弹出不成功的话，把栈指针R6减1，即把第1次弹出的数据压回栈
            ADD     R0, R0, R1      ;第1次弹出的数据与第2次弹出的数据相加，并存放在R0
            JSR     RangeCheck      ;调用范围检查子程序RangeCheck，其中R5会存放状态码。如果上面相加的结果没有超出范围，R5等于0，否则等于1
            BRp     OpAdd_Restore2        
            JSR     PUSH
            BRnzp   OpAdd_Exit
OpAdd_Restore2    ADD     R6, R6, #-1
OpAdd_Restore1    ADD     R6, R6, #-1
OpAdd_Exit      LD      R0, OpAdd_Save0
                LD      R1, OpAdd_Save1
                LD      R5, OpAdd_Save5
                LD      R7, OpAdd_Save7
                RET
OpAdd_Save0     .BLKW	#1
OpAdd_Save1     .BLKW	#1
OpAdd_Save5     .BLKW	#1
OpAdd_Save7     .BLKW	#1

;

OpMult      ST      R0, OpMult_Save0
            ST      R1, OpMult_Save1
            ST      R2, OpMult_Save2
            ST      R3, OpMult_Save3
            ST      R5, OpMult_Save5
            ST      R7, OpMult_Save7
            AND     R3, R3, #0
            JSR     POP
            ADD     R5, R5, #0
            BRp     OpMult_Exit
            ADD     R1, R0, #0
            JSR     POP
            ADD     R5, R5, #0
            BRp     OpMult_Restore1
            ADD     R2, R0, #0
            BRnp    PosMultiplier
            ADD     R3, R3, #1          ;R3存放符号位
            NOT	    R2, R2
            ADD     R2, R2, #1          ;这里为什么是+1而不是减1呢？答案：先取反，再加1，可以实现一样的效果，另外一种方法是先减1，再取反
PosMultiplier   AND     R0, R0, #0     ;这步将R0清零操作之所以放在这里，是因为不管乘数是负数，正数，还是0的情况，都需要执行这一步。
                ADD     R2, R2, #0      ;(∆接上∆)所以放在这里，不管前面怎样跳转，都能执行到这一步
                BRz     PushMult
;
MultLoop    ADD     R0, R0, R1          
            ADD     R2, R2, #-1
            BRp     MultLoop
;
            JSR     RangeCheck
            ADD     R5, R5, #0
            BRp     OpMult_Restore2
;
            ADD     R3, R3, #0
            BRz     PushMult
            NOT     R0, R0
            ADD     R0, R0, #1
PushMult    JSR     PUSH
            BRnzp   OpMult_Exit

OpMult_Restore2 ADD     R6, R6, #-1
OpMult_Restore1 ADD     R6, R6, #-1
OpMult_Exit     LD      R0, OpMult_Save0
                LD      R1, OpMult_Save1
                LD      R2, OpMult_Save2
                LD      R3, OpMult_Save3
                LD      R5, OpMult_Save5
                LD      R7, OpMult_Save7
                RET
OpMult_Save0    .BLKW	#1
OpMult_Save1    .BLKW	#1
OpMult_Save2    .BLKW	#1
OpMult_Save3    .BLKW	#1
OpMult_Save5    .BLKW	#1
OpMult_Save7    .BLKW	#1
;
;
OpNeg       ST      R0, OpNeg_Save0
            ST      R5, OpNeg_Save5
            ST      R7, OpNeg_Save7
            JSR     POP
            ADD     R5, R5, #0
            BRp     OpNeg_Exit
            NOT     R0, R0
            ADD     R0, R0, #1
            JSR     PUSH
OpNeg_Exit  LD      R0, OpNeg_Save0
            LD      R5, OpNeg_Save5
            LD      R7, OpNeg_Save7
            RET
OpNeg_Save0 .BLKW	#1
OpNeg_Save5 .BLKW	#1
OpNeg_Save7 .BLKW	#1
;   
;   This subroutine takes an ASCII string of up to three decimal digits and
;   converts it into a binary number. R0 is used to collect the result.
;   R1 keeps track of how many digits are left to process. ASCIIBUFF
;   contains the most significant digit in the ASCII string.
ASCIItoBinary   ST      R1, AtoB_Save1	
                ST      R2, AtoB_Save2	
                ST      R3, AtoB_Save3	
                ST      R4, AtoB_Save4
                AND     R0, R0, #0      ;R0会用来存放最后结果
                ADD     R1, R1, #0      ;Test number of digits     
                BRz     AtoB_Done
;
                LD      R2, AtoB_ASCIIBUFF  ;
                ADD     R2, R2, R1      ;因为R1代表位数，加上这个位数，就把指针移到了栈底
                ADD     R2, R2, #-1     ;此时R2指向这个3位数字的个位上的数字的地址
;
                LDR     R4, R2, #0      ;把个位上的数字取出来，存放在R4
                ADD     R4, R4, x000F      ;与-x0030相加，即可得到该数值
                ADD     R0, R0, R4      ;把个数上的数值存放到结果寄存器R0上
;
                ADD     R1, R1, #-1
                BRz     AtoB_Done
                ADD     R2, R2, #-1     ;此时R2指向这个3位数字的十位上的数字的地址
;
                LDR     R4, R2, #0
                ADD     R4, R4, x000F
                LEA     R3, LookUp10
                ADD     R3, R3, R4
                LDR     R4, R3, #0
                ADD     R0, R0, R4
;
                ADD     R1, R1, #-1
                BRz     AtoB_Done
                ADD     R2, R2, #-1
;
                LDR     R4, R2, #0
                ADD     R4, R4, x000F
                LEA     R3, LookUp100
                ADD     R3, R3, R4
                LDR     R4, R3, #0
                ADD     R0, R0, R4
                
AtoB_Done       LD      R1, AtoB_Save1	
                LD      R2, AtoB_Save2	
                LD      R3, AtoB_Save3	
                LD      R4, AtoB_Save4
                RET

AtoB_ASCIIBUFF  .FILL	ASCIIBUFF
AtoB_Save1      .BLKW	#1
AtoB_Save2      .BLKW	#1
AtoB_Save3      .BLKW	#1
AtoB_Save4      .BLKW	#1
LookUp10        .FILL	#0
                .FILL	#10
                .FILL	#20
                .FILL	#30
                .FILL	#40
                .FILL	#50
                .FILL	#60
                .FILL	#70
                .FILL	#80
                .FILL	#90
;
LookUp100       .FILL	#0
                .FILL	#100
                .FILL	#200
                .FILL	#300
                .FILL	#400
                .FILL	#500
                .FILL	#600
                .FILL	#700
                .FILL	#800
                .FILL	#900
;
;该程序，如果二进制数值为0，ASCIIBUFF里存放的为ASCII码：+000
BinarytoASCII       ST      R0, BtoA_Save0
                    ST      R1, BtoA_Save1
                    ST      R2, BtoA_Save2
                    ST      R3, BtoA_Save3
                    ;LEA     R1, ASCIIBUFF
                    LD      R1, BtoA_ASCIIBUF
                    ADD     R0, R0, #0          ;R0 contains the binary value
                    BRn     NegSign
                    LD      R2, ASCIIplus       ;栈顶存放符号位,正数或零时即存放+
                    STR     R2, R1, #0
                    BRnzp   Begin100
NegSign             LD      R2, ASCIIminus      ;栈顶存放符号位,负数数即存放-
                    STR     R2, R1, #0
                    NOT     R0, R0
                    ADD     R0, R0, #1
;
Begin100            LD      R2, ASCIIoffset
;
                    LD      R3, Neg100
Loop100             ADD     R0, R0, R3
                    BRn     End100
                    ADD     R2, R2, #1      ;这里是反复对R0减去100，以此来得到百位上数字是几，并把百倍上数字的结果存放在R2,结果是ASCII码值
                    BRnzp   Loop100
;
End100              STR     R2, R1, #1      ;把刚才得到的百位上的数字压入栈
                    LD      R3, Pos100
                    ADD     R0, R0, R3      ;使R0加上100，复原R0的值，因为上面的Loop100操作把R0减为负数了
;
                    LD      R2, ASCIIoffset
;
Begin10             LD      R3, Neg10
Loop10              ADD     R0, R0, R3
                    BRn     End10
                    ADD     R2, R2, #1
                    BRnzp   Loop10
;
End10               STR     R2, R1, #2
                    ADD     R0, R0, #10     ;复原R0的值
Begin1              LD      R2, ASCIIoffset
                    ADD     R2, R2, R0
                    STR     R2, R1, #3
                    LD      R0, BtoA_Save0
                    LD      R1, BtoA_Save1
                    LD      R2, BtoA_Save2
                    LD      R3, BtoA_Save3
                    RET
;
ASCIIplus           .FILL	x002B       ;+号的ASCII码
ASCIIminus          .FILL	x002D       ;-号的ASCII码
ASCIIoffset         .FILL	x0030
Neg100              .FILL	xFF9C       ;等于-x0064,也即等于-100
Pos100              .FILL	x0064
Neg10               .FILL	xFFF6
BtoA_Save0          .BLKW	#1
BtoA_Save1          .BLKW	#1
BtoA_Save2          .BLKW	#1
BtoA_Save3          .BLKW	#1
BtoA_ASCIIBUF       .FILL	ASCIIBUFF
;
;   Subroutine to check that a value is between -999 and +999.
;
RangeCheck      LD      R5, Neg999
                ADD     R4, R0, R5
                BRp     BadRange
                LD      R5, Pos999
                ADD     R4, R0, R5
                BRn     BadRange
                AND     R5, R5, #0
                RET
BadRange        ST      R0, RangeCheck_Save0
                LEA	    R0, RangeErrorMsg
                TRAP	x22
                AND     R5, R5, #0
                ADD     R5, R5, #1
                LD      R0, RangeCheck_Save0
                RET
Neg999          .FILL	#-999
Pos999          .FILL	#999
RangeErrorMsg   .FILL	x000A
                .STRINGZ	"Error: Number is out of range."
RangeCheck_Save0    .BLKW	#1
;   This subroutine POPs a value from the stack and puts it in
;   R0 before returning to the calling program. R5 is used to 
;   report success(R5=0) or failure(R5=1) of the POP operation.
POP             LD      R0, POP_StackBase
                NOT     R0, R0
                ADD     R0, R0, R6
                BRz     Underflow
                LDR     R0, R6, #0
                ADD     R6, R6, #1
                AND     R5, R5, #0
                RET
Underflow       LEA     R0, UnderflowMsg
                PUTS
                AND     R5, R5, #0
                ADD     R5, R5, #1
                RET
UnderflowMsg    .FILL	x000A
                .STRINGZ	"Error: Too Few Values on the Stack."
POP_StackBase   .FILL	StackBase

;   This subroutine PUSHes on the stack the value stored in R0.
;   R5 is used to report success(R5=0) or failure(R5=1) of
;   the PUSH operation
PUSH            ST      R1, PUSH_Save1
                LD      R1, PUSH_StackMax
                NOT     R1, R1
                ADD     R1, R1, #1
                ADD     R1, R1, R6
                BRz     Overflow
                ADD     R6, R6, #-1
                STR     R0, R6, #0
                LD      R1, PUSH_Save1
                AND     R5, R5, #0
                RET
Overflow        LEA     R0, OverflowMsg
                PUTS
                LD      R1, PUSH_Save1
                AND     R5, R5, #0
                ADD     R5, R5, #1
                RET     
PUSH_Save1      .BLKW	#1
OverflowMsg     .FILL	x000A
                .STRINGZ	"Error: Stack is Full."
PUSH_StackMax   .FILL	StackMax

