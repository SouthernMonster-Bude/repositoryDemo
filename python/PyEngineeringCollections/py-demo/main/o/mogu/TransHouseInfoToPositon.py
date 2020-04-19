import json
content = ''
with open('蘑菇租房数据new.json', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    # print(type(content))
file.close()
list = json.loads(content)
# print(type(list))
# print(list)
allList = []
for point in list:
    pos = []
    pos.append(point["lng"])
    pos.append(point["lat"])
    pos.append(point["name"])
    pos.append("蘑菇租房")
    pos.append(point["minPrice"])
    allList.append(pos)
print(len(allList))

filename = "租房position.json"
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(allList, fp, indent=4, ensure_ascii=False))
