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
