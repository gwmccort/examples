#!/bin/bash

curl -XPUT 'http://dm:9200/music/mp3/1?pretty' -d '
{
   "name" : "track name",
   "artist" : "track artist",
   "number" : 1
}
'
