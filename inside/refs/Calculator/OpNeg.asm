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