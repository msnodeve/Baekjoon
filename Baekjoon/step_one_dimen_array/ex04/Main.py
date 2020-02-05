scale = input().split(" ")
scale = [int(i) for i in scale]
for i in range(0, len(scale)-2):
        if scale[i]-scale[i+1] == scale[i+1]-scale[i+2]:
                pass
        else:
                print("mixed")
                exit(0)
if(scale[0]==1):
        print("ascending")
else:
        print("descending")