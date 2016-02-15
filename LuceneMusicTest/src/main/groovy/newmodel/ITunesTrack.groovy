package newmodel

import groovy.transform.ToString

@ToString
class ITunesTrack implements Track {
	static main(args) {
		ITunesTrack t = new ITunesTrack()
		t.artist = 'Grateful Dead'
		t.name = 'Trucking'
		println t
	}
}