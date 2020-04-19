# 121.533358,31.231194 一个小范围起点
# 121.578849,31.205797 一个小范围终点
#
# 121.368006,31.258638 全范围起点
# 121.7539,30.898438 全范围终点
import json

lp = (121.533358, 31.231194)
rp = (121.578849, 31.205797)
rect = (lp[0] - rp[0], lp[1] - rp[1])
print(rect)

Lp = (121.337405,31.344389)
Rp = (121.790591,31.00541)
ARect = (Lp[0] - Rp[0], Lp[1] - Rp[1])
print(ARect)

row = round(ARect[0] / rect[0])
left = round(ARect[1] / rect[1])
print(str(row) + "," + str(left))
firstPos = (Lp[0] - rect[0] * 0.5, Lp[1] - rect[1] * 0.5)
AllPos = [firstPos]
for i in range(0, row):
    for j in range(0, left):
        pos = (firstPos[0] - rect[0] * i, firstPos[1] - rect[1] * j)
        AllPos.append(pos)

print(AllPos)

filename = '中心点坐标.json'
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(AllPos, fp, indent=4, ensure_ascii=False))
fp.close()
