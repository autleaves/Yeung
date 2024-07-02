
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