import json

content = ''
with open('距离和价格.json', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    # print(type(content))
file.close()
list = json.loads(content)

# print(type(list))
# print(list)

for point in list:
    # point['suggestion'] = int(point['suggestion'] * 10 ** 7)
    rate = 0.3;
    overprice = (float(point['price']) - 3500) ** 1.5 + 100
    overtime = (float(point['expensetime']) - 30)
    point['suggestion'] = (overprice * overtime)

list = sorted(list, key=lambda item: item['suggestion'])
for point in list:
    if float(point['price']) < 4500 and float(point['price']) > 4000:
        point['suggestion'] = 1 / point['suggestion'] * 10 ** 6 /13.861460421215849 *100
        print(point)
print(len(list))
