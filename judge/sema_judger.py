import os

command = "java -jar Masterball.jar < {input_file} > {output_file}"

judge_list = open("testcases/sema/judgelist.txt").readlines()

cnt = 0

for judge in judge_list:
    cnt += 1
    input_file = judge.replace("\n", "").replace("./", "testcases/sema/")
    output_file = "result/" + str(cnt) + ".txt"

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
    print("testing case:", cnt, input_file, "\n")