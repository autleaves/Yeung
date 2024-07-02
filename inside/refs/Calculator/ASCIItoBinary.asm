;   
;   This subroutine takes an ASCII string of up to three decimal digits and
;   converts it into a binary number. R0 is used to collect the result.
;   R1 keeps track of how many digits are left to process. ASCIIBUFF
;   contains the most significant digit in the ASCII string.
ASCIItoBinary   ST      R1, AtoB_Save1	
                ST      R2, AtoB_Save2	
                ST      R3, AtoB_Save3	
                ST      R4, AtoB_Save4
                AND     R0, R0, #0      ;R0会用来存放最后结果
                ADD     R1, R1, #0      ;Test number of digits     
                BRz     AtoB_Done
;
                LD      R2, AtoB_ASCIIBUFF  ;
                ADD     R2, R2, R1      ;因为R1代表位数，加上这个位数，就把指针移到了栈底
                ADD     R2, R2, #-1     ;此时R2指向这个3位数字的个位上的数字的地址
;
                LDR     R4, R2, #0      ;把个位上的数字取出来，存放在R4
                ADD     R4, R4, x000F      ;与-x0030相加，即可得到该数值
                ADD     R0, R0, R4      ;把个数上的数值存放到结果寄存器R0上
;
                ADD     R1, R1, #-1
                BRz     AtoB_Done
                ADD     R2, R2, #-1     ;此时R2指向这个3位数字的十位上的数字的地址
;
                LDR     R4, R2, #0
                ADD     R4, R4, x000F
                LEA     R3, LookUp10
                ADD     R3, R3, R4
                LDR     R4, R3, #0
                ADD     R0, R0, R4
;
                ADD     R1, R1, #-1
                BRz     AtoB_Done
                ADD     R2, R2, #-1
;
                LDR     R4, R2, #0
                ADD     R4, R4, x000F
                LEA     R3, LookUp100
                ADD     R3, R3, R4
                LDR     R4, R3, #0
                ADD     R0, R0, R4
                
AtoB_Done       LD      R1, AtoB_Save1	
                LD      R2, AtoB_Save2	
                LD      R3, AtoB_Save3	
                LD      R4, AtoB_Save4
                RET

AtoB_ASCIIBUFF  .FILL	ASCIIBUFF
AtoB_Save1      .BLKW	#1
AtoB_Save2      .BLKW	#1
AtoB_Save3      .BLKW	#1
AtoB_Save4      .BLKW	#1
LookUp10        .FILL	#0
                .FILL	#10
                .FILL	#20
                .FILL	#30
                .FILL	#40
                .FILL	#50
                .FILL	#60
                .FILL	#70
                .FILL	#80
                .FILL	#90
;
LookUp100       .FILL	#0
                .FILL	#100
                .FILL	#200
                .FILL	#300
                .FILL	#400
                .FILL	#500
                .FILL	#600
                .FILL	#700
                .FILL	#800
                .FILL	#900