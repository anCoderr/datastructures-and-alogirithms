import time
import threading
import concurrent.futures

start_time = time.time()

def do_something(sleep_time):
    print(f'Sleeping for {sleep_time} second(s)...')
    time.sleep(sleep_time)
    print('Done Sleeping...')

## This will take 3+ seconds to execute due to serial processing. 
# do_something(1.5)
# do_something(1.5)

## This will take 1.5+ seconds to execute due to parallel processing.
# start_time = time.time()
# t1 = threading.Thread(target=do_something)
# t2 = threading.Thread(target=do_something)
# t1.start()
# t2.start()
# t1.join()
# t2.join()
# finish_time = time.time()
# print(f'Finished in {(finish_time - start_time):.2f} seconds')


## This will take 1.5+ seconds to execute due to parallel processing.
threads = []
for _ in range(10):
    t = threading.Thread(target=do_something, args=[1.5])
    t.start()
    threads.append(t)
for thread in threads:
    thread.join()



finish_time = time.time()
print(f'Finished in {(finish_time - start_time):.2f} seconds')