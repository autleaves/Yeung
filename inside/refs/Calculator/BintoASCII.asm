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