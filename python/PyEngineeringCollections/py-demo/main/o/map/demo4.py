import json

content = ''
blanksvg = ''

svgList = []
# with open('py-demo/main/o/map/china.json', encoding='utf-8') as file:
with open('china.json', encoding='utf-8') as file:
    content = file.read()
file.close()
with open('svg/blank.svg', encoding='utf-8') as file:
    blanksvg = file.read()
file.close()
map = json.loads(content)
str1 = "".join(blanksvg)
pathMod = "<path d='#CONTENT#'/>"
for k, v in map.items():
    strs = ""
    for k1, v1 in v.items():
        path = "".join(pathMod).replace("#CONTENT#", v1)
        strs = strs + path
        pass
    k_svg = "".join(blanksvg).replace("#CONTENT#", strs)
    filename = 'svg/' + k + '.svg'
    with open(filename, 'w', encoding='utf-8') as fp:
        fp.write(k_svg)
    pass
