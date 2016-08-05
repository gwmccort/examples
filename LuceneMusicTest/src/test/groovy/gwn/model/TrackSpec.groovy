package gwn.model

import gwm.model.Track
import spock.lang.*

/**
 * Created by gwmccort on 2/16/2016.
 */
class TrackSpec extends Specification {

	def "track objects are equal"() {
		when:
		def t1 = new Track(name:'name1', artist:'artist1', album:'album')
		def t2 = new Track(name:'name1', artist:'artist1', album:'album')
		
		then:
		t1 == t2
		t1.equals(t2)
		t1.hashCode() == t2.hashCode()
	}
	
	def "track objects are not equal"() {
		when:
		def t1 = new Track(name:'name1', artist:'artist1', album:'album')
		def t2 = new Track(name:'name2', artist:'artist1', album:'album')
		
		then:
		t1 != t2
		!(t1.equals(t2))
	}
	
	def "equal ignores track"() {
		when:
		def t1 = new Track(name:'name1', artist:'artist1', album:'album', track:'1')
		def t2 = new Track(name:'name1', artist:'artist1', album:'album', track:'2')
				
		then:
		t1 == t2
	}
	
	def "sort"() {
		when:
		def t1 = new Track(name:'name1', artist:'artist1', album:'album')
		def t2 = new Track(name:'name2', artist:'artist1', album:'album')
		
		def tracks = []
		tracks.addAll(t2, t1)
		tracks = tracks.sort()
		
		then:
		tracks == [t1, t2]
	}
	
//	@Ignore
	def "set sort"() {
		when:
		Track t1 = new Track(name:'name1', artist:'artist1', album:'album')
		Set<Track> s1 = [] as Set
		s1 << t1
		
		def t2 = new Track(name:'name2', artist:'artist1', album:'album')
		Set<Track> s2 = [] as Set
		s2 << t2
		
		def t3 = new Track(name:'name3', artist:'artist1', album:'album')
		Set<Track> s3 = [] as Set
		s3 << t3
		
		Set<Track> tracks = [] as Set
		tracks.addAll(t2, t3, t1)
		tracks = tracks.sort()
		
		then:
		tracks[0].name == t1.name
		tracks[1].name == t2.name
		tracks[2].name == t3.name
	}
}
