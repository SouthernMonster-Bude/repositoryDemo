import json

content = ''
with open('距离和价格Final.json', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    # print(type(content))
file.close()
list = json.loads(content)

# print(type(list))
# print(list)

for point in list:
    # point['suggestion'] = int(point['suggestion'] * 10 ** 7)
    rate = 0.3
    overprice = (float(point['price']) - 3500) ** 1.5 + 100
    overtimeH = (float(point['expensetime-HC']) - 30)
    overtimeL = (float(point['expensetime-LZY']) - 30)
    overtimeJ = (float(point['expensetime-JDG']) - 30)
    point['suggestion'] = (overprice * (overtimeH + overtimeL + overtimeJ))

list = sorted(list, key=lambda item: item['suggestion'])
suggestionList = []
limitTime = 70
for point in list:
    if float(point['price']) < 6000 and float(point['price']) > 4000 and point['expensetime-HC'] < limitTime \
            and point['expensetime-LZY'] < limitTime and point['expensetime-JDG'] < 70:
        point['suggestion'] = 1 / point['suggestion'] * 10 ** 6  # /13.861460421215849 *100
        suggestionList.append(point)
        print(point)
print(len(list))

filename = "Suggestion.json"
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(suggestionList, fp, indent=4, ensure_ascii=False))
fp.close()
