# install ip2geotools
# Get IP and location from a URL
# Author: @itChallenges

import socket
from ip2geotools.databases.noncommercial import DbIpCity
url = input("Insert an URL: ")
ip = socket.gethostbyname(url)
response = DbIpCity.get(ip, api_key='free')
print("IP: ", ip)
print("City: ", response.city)
print("Region: ", response.region)
print("Country: ", response.country)