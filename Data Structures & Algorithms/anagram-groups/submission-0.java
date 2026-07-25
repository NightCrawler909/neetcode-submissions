class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length ; i++){

            String s = strs[i];

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String newstrs = new String(arr);

            if(!map.containsKey(newstrs)){
                map.put(newstrs,new ArrayList<>());
            }

            map.get(newstrs).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
