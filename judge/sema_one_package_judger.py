import os

command = "java -jar Masterball.jar < {input_file} > {output_file}"

package_name = input("Please input the package name. (codeforces-package not support now) :")
test_num = input("Please input the num of testcases: ")

for i in range(1, int(test_num) + 1):
    input_file = "testcases/sema/" + package_name + "-package/" + package_name + "-" + str(i) + ".mx"
    output_file = "result/" + package_name + "-" + str(i) + ".txt"
   
    fp = open(input_file) 
    lines = fp.readlines()
    std = ""
    cmt = ""
    for line in lines:
        if line.find("Verdict") != -1:
            std = line.replace("\n", "")
        
        if line.find("Comment") != -1:
            cmt = line.replace("\n", "")

    print("[std]", std, cmt)
    
    os.system(command.format(input_file = input_file, output_file = output_file))
    print("testing case:", i, "\n")