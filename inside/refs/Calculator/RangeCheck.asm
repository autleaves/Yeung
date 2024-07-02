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


