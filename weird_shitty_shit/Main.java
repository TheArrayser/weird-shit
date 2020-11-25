package weird_shitty_shit;

public class Main {

	static Dude[] dudes = new Dude[10];
	static Dude empty = new Dude(0, "E");
	static Dude a = new Dude(5, "a");
	static Dude b = new Dude(10, "b");
	static Dude m = new Dude(20, "m");
	static Dude v = new Dude(25, "v");
	
	//abmv
	
	public static void main(String[] args) {
		int ccc = 0;
		//System.out.println(26&1);
		for(int i = 0; i<10; i++) {
			dudes[i]=empty;
		}
		
		while(dudes[9]!=v) {
			empty.parity = 0;
			a.parity = 0;
			b.parity = 0;
			m.parity = 0;
			v.parity = 0;
			
			for(int i = 0; i<10; i++) {
				if(dudes[i]==empty) {
					dudes[i]=a;
					break;
				}else if(dudes[i]==a) {
					dudes[i]=b;
					break;
				}else if(dudes[i]==b) {
					dudes[i]=m;
					break;
				}else if(dudes[i]==m) {
					dudes[i]=v;
					break;
				}else if(dudes[i]==v) {
					dudes[i]=empty;
				}
			}
			
			if(dudes[0]==empty&&dudes[1]==empty) {
				continue;
			}
			
			dudes[0].parity++;
			dudes[1].parity++;
			if (!checkparity()) {
				continue;
			}
			
			if(dudes[2]==empty&&dudes[3]==empty) {
				continue;
			}
			dudes[2].parity--;
			dudes[3].parity--;
			if (!checkparity()) {
				continue;
			}
			
			
			if(dudes[4]==empty&&dudes[5]==empty) {
				continue;
			}
			dudes[4].parity++;
			dudes[5].parity++;
			if (!checkparity()) {
				continue;
			}
			
			if(dudes[6]==empty&&dudes[7]==empty) {
				continue;
			}
			dudes[6].parity--;
			dudes[7].parity--;
			if (!checkparity()) {
				continue;
			}
			
			
			if(dudes[8]==empty&&dudes[9]==empty) {
				continue;
			}
			dudes[8].parity++;
			dudes[9].parity++;
			if (!checkparity()) {
				continue;
			}
			
			if(((a.parity)&1) == 0) {
				continue;
			}else if(((b.parity)&1) == 0) {
				continue;
			}else if(((m.parity)&1) == 0) {
				continue;
			}else if(((v.parity)&1) == 0) {
				continue;
			}
			
			int time = 0;
			for(int t = 0; t<10; t=t+2) {
				if(dudes[t].time > dudes[t+1].time) {
					time = time + dudes[t].time;
				}else {
					time = time + dudes[t+1].time;
				}
				
			}
			
			if(time <= 60) {
			for(int oo = 0; oo<10; oo++) {
				System.out.print(dudes[oo].name);
			}
			System.out.println();
			ccc++;
			}
			
				
		}
		System.out.println("possible solutions: " + ccc);
		System.out.println("distinguishable solutions: " + ccc/8);
	}
	static boolean checkparity() {
		if(a.parity<0 || a.parity>1) {
			return false;
		}else if(b.parity<0 || b.parity>1) {
			return false;
		}else if(m.parity<0 || m.parity>1) {
			return false;
		}else if(v.parity<0 || v.parity>1) {
			return false;
		}
		return true;
		
	}
}
