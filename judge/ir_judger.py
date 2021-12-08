import os
import time

command = "cp {code_file} ../local/test.mx && cp input.txt ../local/input.txt && cd ../local/ && ./llvmrun.bash < {input_file} > {output_file} && cp output.txt ../judge/output.txt && cd ../judge/"

judge_list = open("testcases/codegen/judgelist.txt").readlines()

cnt = 0

for judge in judge_list:
    cnt += 1
    
    code_file = judge.replace("\n", "").replace("./", "testcases/codegen/")
    input_file = "input.txt"
    output_file = "output.txt"
    std_file = "std.txt"

    input_fp = open(input_file, "w")
    output_fp = open(output_file, "w")
    std_fp = open(std_file, "w")

    fp = open(code_file) 
    lines = fp.readlines()

    input_start = False
    std_start = False

    for i in range(len(lines)):
        if lines[i].find("= output =") > 0:
            std_start = True
        elif lines[i].find("= input =") > 0:
            input_start = True
        elif lines[i].find("= end =") > 0:
            input_start = False
            std_start = False
        elif input_start:
            input_fp.write(lines[i]) 
        elif std_start:
            std_fp.write(lines[i])

    input_fp.close() 
    output_fp.close()
    std_fp.close()

    print("\033[34m Loading finish. Start to run LLVM IR.")

    os.system(command.format(code_file = code_file, input_file = input_file, output_file = output_file))
    wrap = os.popen("diff {file1} {file2} -w -B".format(file1 = output_file, file2 = std_file))
    info = wrap.readlines()

    if len(info) == 0:
        print("\033[32m[Success] [test]: in {testpoint} \033[0m".format(testpoint = code_file + ", point " + str(cnt)))
    else:
        print("\033[31m[Failed] [test]: in {testpoint} \033[0m".format(testpoint = code_file + ", point " + str(cnt)))
        # print("[info]: ", info)
        # exit(-1)
    
    time.sleep(1)