class Solution {
public:
    int compareVersion(string version1, string version2) {
        // Split version strings into revisions
        vector<int> v1 = splitVersion(version1);
        vector<int> v2 = splitVersion(version2);

        int n = max(v1.size(), v2.size());

        // Compare each revision
        for (int i = 0; i < n; i++) {
            int rev1 = (i < v1.size()) ? v1[i] : 0;
            int rev2 = (i < v2.size()) ? v2[i] : 0;

            if (rev1 < rev2) return -1;
            else if (rev1 > rev2) return 1;
        }

        return 0; // Both versions are equal
    }

private:
    vector<int> splitVersion(string version) {
        vector<int> revisions;
        istringstream iss(version);
        string revision;

        while (getline(iss, revision, '.')) {
            revisions.push_back(stoi(revision));
        }

        return revisions;
    }
};
