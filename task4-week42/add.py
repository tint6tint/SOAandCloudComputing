from bottle import get, post, request, run # or route
import riak

myClient=riak.RiakClient(protocol='http', host='192.168.122.149', http_port=8098)   

@get('/add') # or @route('/add')
def login():
    return '''
        <form action="/add" method="post">
            Username: <input name="username" type="text" />
            Phonenumber: <input name="phonenumber" type="text" />
            <input value="add" type="submit" />
        </form>
    '''

@post('/add') # or @route('/add', method='POST')
def do_login():
    username = request.forms.get('username')
    phonenumber = request.forms.get('phonenumber')
	myBucket = myClient.bucket('test') 
	key1 = myBucket.new(username, data=phonenumber)
	key1.store()

@get('/search/<name>') # or @route('/search/<name>')
def search(name):
	myBucket = myClient.bucket('test') 
    fetched1 = myBucket.get(name)
    phonenumber = fetched1.data
	return phonenumber
		
run(host='192.168.122.223', port=8098)
		
		
