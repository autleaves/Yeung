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