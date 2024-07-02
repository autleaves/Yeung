;
;
OpClear         LEA     R6, OpClear_StackBase
                ADD     R6, R6, #1
                RET
OpClear_StackBase   .FILL	StackBase