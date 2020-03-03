from selenium import webdriver


# driver = webdriver.Chrome()

driver = webdriver.PhantomJS()

driver.get('http://baidu.com')

driver.page_source