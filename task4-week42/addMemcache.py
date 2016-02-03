from bottle import get, post, request, run # or route

import riak
import pylibmc
import cherrypy


#myClient=riak.RiakClient(protocol='http', host='192.168.122.149', http_port=8098)   
myClient=riak.RiakClient(host="192.168.122.149", port=8087, protocol='pbc')

mc = pylibmc.Client(["192.168.122.223"], binary=True, behaviors={"tcp_nodelay": True, "ketama": True})

@get('/addMemcache') # or @route('/add')

def login():
    return '''
        <form action="/addMemcache" method="post">
            Username: <input name="username" type="text" />
            Phonenumber: <input name="phonenumber" type="text" />
            <input value="addMemcache" type="submit" />
        </form>
    '''

@post('/addMemcache') # or @route('/add', method='POST')
def do_login():
    username = request.forms.get('username')
    phonenumber = request.forms.get('phonenumber')
	myBucket = myClient.bucket('test') 
	key1 = myBucket.new(username, data=phonenumber)
	key1.store()
	mc[username]= phonenumber
	

@get('/searchMemcache/<name>') # or @route('/search/<name>')
def search(name):
	myBucket = myClient.bucket('test') 
	phonenumberInMemcach = mc.get(name)
    fetched1 = myBucket.get(name)
    phonenumber = fetched1.data
	print phonenumber
	print phonenumberInMemcach
	return 0
	
		
run(host='192.168.122.223', port=8098, server="cherrypy")
		
		
