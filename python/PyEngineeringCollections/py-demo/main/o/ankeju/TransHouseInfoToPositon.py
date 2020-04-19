import json

content = ''
with open('安居客数据new.json', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    # print(type(content))
file.close()
list = json.loads(content)
# print(type(list))
# print(list)
# 偏置
b = (0.006591999999997711, 0.005641000000000673);
allList = []
for point in list:
    pos = []

    pos.append(float(point["lng"])-b[0])
    pos.append(float(point["lat"])-b[1])
    pos.append(point["name"])
    pos.append("安客居")
    pos.append('5000-7000')
    allList.append(pos)
print(len(allList))

filename = "租房position.json"
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(allList, fp, indent=4, ensure_ascii=False))

# 121.493886,31.176132
# 121.500478,31.181773
