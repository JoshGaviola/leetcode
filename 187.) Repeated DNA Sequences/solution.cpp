class Solution {
public:
vector<string> findRepeatedDnaSequences(string s) {
        vector<string> l;
        int n=s.size();
        int inp[n];
        int bit=0;
        unordered_map<int,int> m;
        if(n<10) return l;
        for(int i=0;i<n;i++){
            if(s[i]=='A') inp[i]=0;
            else if(s[i]=='C') inp[i]=1;
            else if(s[i]=='G') inp[i]=2;
            else inp[i]=3;
        }
        for(int i=0;i<10;i++){
            bit<<=2;
            bit|=inp[i];
        }
        m[bit]++;
        for(int i=1;i<n-9;i++){
            bit<<=2;
            bit|=inp[i+9];
            bit&=~(1<<(2*10));
            bit&=~(1<<(2*10 +1));
            //or bit&=~(3<<(2*10)) directly
            m[bit]++;
            if(m[bit]==2) l.push_back(s.substr(i,10));

        }
        return l;
      }

};