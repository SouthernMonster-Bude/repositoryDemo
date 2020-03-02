from pyquery import PyQuery

doc = PyQuery('<html>Hello</html>')
res = doc('html').text()
print(doc)
print(res)