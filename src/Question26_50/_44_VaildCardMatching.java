package Question26_50;

public class _44_VaildCardMatching {
	 /** 
     * @param s: A string  
     * @param p: A string includes "?" and "*" 
     * @return: A boolean 
     */  
    // greedy method 
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		int si = 0;
		int pi = 0;
		int smatch = -1;
		int pstar = -1;
		
		
		
		if(slen==0 && plen==0 ) {
			return true;
		}
		
		while(si < slen) {
			if( pi < plen  && (s.charAt(si) == p.charAt(pi) || p.charAt(pi)=='?')) {
				si++;
				pi++;
			}
			else if(p.charAt(pi)=='*') {
				pstar = pi;
				smatch = si;
				pi++;
			}
			else if( pstar != -1) {
				pi = pstar + 1;
				si = smatch + 1;
				smatch++;
				
			}else {
				return false;
			}
		
		
		}
		while(pi < plen && p.charAt(pi)=='*') {
			pi++;
		}
		if(pi == plen) {
			return true;
		}else {
			return false;
		}

	}
}
