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