package newmodel


//@ToString(includeNames=true)
class ITunesTrack implements Track {
	static main(args) {
		ITunesTrack t = new ITunesTrack()
		t.artist = 'Grateful Dead'
		t.name = 'Trucking'
		println "iTunesTrack: ${t.toString()}"
	}

	//TODO @ToString doesn't work w/ traits???
	public String toString() {
		return "ITunesTrack[artist:${artist}, name:${name}, album:${album}"
	}
}