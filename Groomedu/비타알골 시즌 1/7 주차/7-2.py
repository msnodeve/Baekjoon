# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import math
import operator as op
from functools import reduce

# 최종 위치, 도토리 위치, 함정 위치
finalN, finalM = map(int, input().split())
dotoriX, dotoriY = map(int, input().split())
hamjungX, hamjungY = map(int, input().split())

# math.factorial(20)

def nCr(n, r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return int(numer / denom)

# 토도리 위치와 함정 위치를 판별
if dotoriX < hamjungX: # 도토리 위치보다 함정 위치가 오른쪽에 있는 경우
	daramgiFromDotori = nCr(int(dotoriX) + int(dotoriY), int(dotoriX))
	dotoriFromFinal = nCr(int(finalN) - int(dotoriX) + int(finalM) - int(dotoriY), int(finalN) - int(dotoriX))
	hamjungFromDotori = nCr(int(hamjungX) - int(dotoriX) + int(hamjungY) - int(dotoriY), int(hamjungX) - int(dotoriX))
	finalFromHamjung = nCr(int(finalN) - int(hamjungX) + int(finalM) - int(hamjungY), int(finalN) - int(hamjungX))
	print((daramgiFromDotori * (dotoriFromFinal - (hamjungFromDotori * finalFromHamjung))) % 1000000007)
else:
	hamjungFromDotori = nCr(int(finalN) - int(dotoriX) + int(finalM) - int(dotoriY), int(finalN) - int(dotoriX))
	daramgiFromDotori = nCr(int(dotoriX) + int(dotoriY), int(dotoriX))
	hamjungFromDaramhi = nCr(int(hamjungX) + int(hamjungY), int(hamjungX))
	dotoriFromHamjung = nCr(int(dotoriX) - int(hamjungX) + int(dotoriY) - int(hamjungY), int(dotoriX) - int(hamjungX))
	print((hamjungFromDotori * (daramgiFromDotori - (hamjungFromDaramhi * dotoriFromHamjung))) % 1000000007)