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
