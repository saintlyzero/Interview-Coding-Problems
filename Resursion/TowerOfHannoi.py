def SolveTowerHannoi(n, from_rod, to_rod, temp_rod):
    if n == 1:
        print("Move Disk 1 from rod {} to rod {}".format(from_rod, to_rod))
        return
    SolveTowerHannoi(n-1, from_rod, temp_rod, to_rod)
    print("Move Disk {} from rod {} to rod {}".format(n, from_rod, to_rod))
    SolveTowerHannoi(n-1, temp_rod, to_rod, from_rod)

n = 5
SolveTowerHannoi(n, 'A', 'B', 'C')