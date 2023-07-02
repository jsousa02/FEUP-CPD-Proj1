from os import system, wait

# 1

for size in range(600, 3001, 400):
    print(f"\n\n\n\nC++ (1 / {size}):", flush=True)
    system(f"echo -e \"1\\n{size}\\n0\\n\" | ./main")
    print(f"\n\n\n\nJava (1 / {size}):", flush=True)
    system(f"echo -e \"1\\n{size}\\n0\\n\" | java MatrixMultiplication")

# 2

for size in range(600, 3001, 400):
    print(f"\n\n\n\nC++ (2 / {size}):", flush=True)
    system(f"echo -e \"2\\n{size}\\n0\\n\" | ./main")
    print(f"\n\n\n\nJava (2 / {size}):", flush=True)
    system(f"echo -e \"2\\n{size}\\n0\\n\" | java MatrixMultiplication")


for size in range(4096, 10241, 2048):
    print(f"\n\n\n\nC++ (2 / {size}):", flush=True)
    system(f"echo -e \"2\\n{size}\\n0\\n\" | ./main")

# 3

for size in range(4096, 10241, 2048):
    block = 64
    while block <= 1024:
        print(f"\n\n\n\nC++ (3 / {size} / {block}):", flush=True)
        system(f"echo -e \"3\\n{size}\\n{block}\\n0\\n\" | ./main")
        block *= 2
