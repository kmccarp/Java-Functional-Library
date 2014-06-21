package functional

import spock.lang.Specification;

class FunSpec extends Specification {
	
	def "when zipping with index, the length of the resulting list is the same as the original list"() {
		given:
		List<String> strings = ["Washington", "Jefferson", "Adams", "Obama"]
		
		when:
		def zip = Fun.zipWithIndex(strings)
		
		then:
		zip.size() == 4
		zip.get(0).left == "Washington"
		zip.get(0).right == 0
	}
	
	def "when zipping two lists of the same length, the tuple list is the same length"() {
		given:
		List<Integer> ints = [1, 2, 3, 4, 5]
		
		and:
		List<String> strings = ["One", "Two", "Three", "Four", "Five"]
		
		when:
		def zip = Fun.zip(ints, strings) 
		
		then:
		zip.size() == 5
		zip.get(0).left == 1
		zip.get(0).right == "One"
		zip.get(1).left == 2
		zip.get(1).right == "Two"
	}
	
	def "when zipping two lists of different lengths, the tuple list is the length of the shorter."() {
		given:
		List<Integer> ints = [1, 2]
		
		and:
		List<String> strings = ["One", "Two", "Three", "Four", "Five"]
		
		when:
		def zip = Fun.zip(ints, strings)
		
		then:
		zip.size() == 2
		zip.get(0).left == 1
		zip.get(0).right == "One"
		zip.get(1).left == 2
		zip.get(1).right == "Two"
	}

}
