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