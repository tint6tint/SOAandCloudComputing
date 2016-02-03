README
=======
Reflective questions

Provide an answer to the following questions in a readme file in your repo

How would you implement a page which shows a list of files. See also List keys.

By request shell 
GET /buckets/bucket/keys?keys=true    # List all keys
GET /buckets/bucket/keys?keys=stream  # Stream keys to the client

then use the curl in terminal
curl -i http://localhost:8098/buckets/jsconf/keys?keys=true
HTTP/1.1 200 OK
Vary: Accept-Encoding
Server: MochiWeb/1.1 WebMachine/1.9.0 (participate in the frantic)
Date: Fri, 30 Sep 2011 15:24:35 GMT
Content-Type: application/json
Content-Length: 239


Why would you ever use a set-up with virtual machines in a real (production) 

environment? Or would you not?

I think I would. For the testing purpose possiblely.

Which of the optimizations made sense, which ones not?

The database is not published online and only able to touch on the localhost and 

with the other virtual machine. It's not really practicle.

What should be improved in this exercise if it is given to students in the 

future?

In this exercise has more intructions than the others which is nice. But for a 

starter like me never used ssh-key. So I made a horrible mistake so I locked the 

server. So more specific intruduction for a starter like me would be nice.