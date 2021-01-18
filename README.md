# TravelingSalesmen

Scanner to find the number of cities;
Mathematical method:

Parsing:
if city isn't in array, add it; then length array


Start(3):
	paths = [0]
			[1]
			[2]
	ArrayList<ArrayList<Integer>> paths
	for(int i = 0; i < cities.size(); i++) 
		ArrayList<Integer> apath
		apath.add(i)
		paths.add(apath)


while(path.get(0)).size() < cities.size()
Iterating 1
	paths = [0, 1]
			[0, 2]
			[1, 0]
			[1, 2]
			...
	for(ArrayLists in ArrayList<ArrayList> paths)
		for(int i = 0; i < cities.size(); i++)
			if(ArrayList doesn't contain i)
				add i


Iterating 2
	paths = [0, 1, 2]
			[0, 2, 1]
			[1, 0, 2]
			[1, 2, 0]
			...

Go through each path and add costs
for(i : paths)
	for
		add
	if total < min, min = total


