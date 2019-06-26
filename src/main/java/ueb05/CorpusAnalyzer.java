package ueb05;

import java.util.*;

class CorpusAnalyzer {
	private List<String> theses;

	CorpusAnalyzer(Iterator<String> thesesIterator) {
		while (thesesIterator.hasNext()){
			theses.add(thesesIterator.next());
		}
	}

	/**
	 * Gibt die Anzahl der angefertigten Theses zurück
	 */
	int countTheses() {
		return theses.size();
	}

	/**
	 * Gibt die durchschnittliche Länge von Titeln in Worten zurück
	 */
	int averageThesisTitleLength() {
		int n = 0;
		for (String s : theses){
			n += s.split(" ").length;
		}
		return n/theses.size();
	}

	/**
	 * Gibt eine alphabetisch absteigend sortierte und duplikatfreie
	 * Liste der ersten Wörter der Titel zurück.
	 */
	List<String> uniqueFirstWords() {
		Set <String> unique = new HashSet<>();
		for(String s: theses){
			unique.add(s.split(" ")[0]);
		}
		List <String> titel = new LinkedList<>();
		titel.addAll(unique);
		titel.sort(Collections.reverseOrder());

		return titel;
	}

	/**
	 * Gibt einen Iterator auf Titel zurück; dabei werden alle Woerter, welche
	 * in `blackList` vorkommen durch Sternchen ersetzt (so viele * wie Buchstaben).
	 */
	Iterator<String> censoredIterator(Set<String> blackList) {
		return new Iterator <String> (){
			Iterator <String> it = theses.iterator();

			public boolean hasNext(){
				return it.hasNext();
			}

			public String next(){
				String s = it.next();
				for(String c: blackList){
					s = s.replaceAll(c, repeat("*", c.length()));
				}
				return s;
			}
		};
	}

	/**
	 * Gibt eine Liste von allen Titeln zurueck, wobei Woerter so ersetzt werden,
	 * wie sie in der Map abgebildet werden, und die Liste nach Stringlaenge absteigend sortiert ist.
	 */
	List<String> normalizedTheses(Map<String, String> replace) {
		throw new UnsupportedOperationException();
	}
}
