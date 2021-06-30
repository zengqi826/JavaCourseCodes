1.（选做）使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

串行
``` 
java -Xmx512m -Xms512m -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log GCLogAnalysis

PS F:\github\JavaCourseCodes\01jvm> java -Xmx512m -Xms512m -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9546

Java HotSpot(TM) 64-Bit Server VM (25.192-b04) for windows-amd64 JRE (1.8.0_192-ea-b04), built on Aug  1 2018 20:11:41 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 16688036k(8143580k free), swap 19702692k(6603852k free)
CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=536870912 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC 
2021-06-29T17:02:35.974+0800: 0.194: [GC (Allocation Failure) 2021-06-29T17:02:35.976+0800: 0.197: [DefNew: 139776K->17472K(157248K), 0.0297976 secs] 139776K->46749K(506816K), 0.0323169 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
2021-06-29T17:02:36.027+0800: 0.248: [GC (Allocation Failure) 2021-06-29T17:02:36.027+0800: 0.248: [DefNew: 157248K->17471K(157248K), 0.0356930 secs] 186525K->85914K(506816K), 0.0357487 secs] [Times: user=0.01 sys=0.03, real=0.04 secs] 
2021-06-29T17:02:36.083+0800: 0.304: [GC (Allocation Failure) 2021-06-29T17:02:36.083+0800: 0.304: [DefNew: 156823K->17471K(157248K), 0.0285703 secs] 225266K->133731K(506816K), 0.0286240 secs] [Times: user=0.01 sys=0.02, real=0.03 secs] 
2021-06-29T17:02:36.134+0800: 0.355: [GC (Allocation Failure) 2021-06-29T17:02:36.134+0800: 0.355: [DefNew: 157247K->17472K(157248K), 0.0308180 secs] 273507K->181250K(506816K), 0.0308724 secs] [Times: user=0.02 sys=0.02, real=0.03 secs] 
2021-06-29T17:02:36.184+0800: 0.405: [GC (Allocation Failure) 2021-06-29T17:02:36.184+0800: 0.405: [DefNew: 157248K->17471K(157248K), 0.0317698 secs] 321026K->226857K(506816K), 0.0318275 secs] [Times: user=0.00 sys=0.03, real=0.03 secs] 
2021-06-29T17:02:36.238+0800: 0.459: [GC (Allocation Failure) 2021-06-29T17:02:36.238+0800: 0.459: [DefNew: 157247K->17470K(157248K), 0.0280408 secs] 366633K->268424K(506816K), 0.0280980 secs] [Times: user=0.00 sys=0.02, real=0.03 secs] 
2021-06-29T17:02:36.288+0800: 0.508: [GC (Allocation Failure) 2021-06-29T17:02:36.288+0800: 0.508: [DefNew: 157246K->17471K(157248K), 0.0250078 secs] 408200K->308623K(506816K), 0.0250635 secs] [Times: user=0.01 sys=0.00, real=0.02 secs] 
2021-06-29T17:02:36.335+0800: 0.555: [GC (Allocation Failure) 2021-06-29T17:02:36.335+0800: 0.555: [DefNew: 157247K->17470K(157248K), 0.0275924 secs] 448399K->353501K(506816K), 0.0276606 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2021-06-29T17:02:36.383+0800: 0.603: [GC (Allocation Failure) 2021-06-29T17:02:36.383+0800: 0.603: [DefNew: 157246K->157246K(157248K), 0.0000172 secs]2021-06-29T17:02:36.383+0800: 0.603: [Tenured: 336031K->277589K(349568K), 0.0333785 secs] 493277K->277589K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0334862 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
2021-06-29T17:02:36.434+0800: 0.655: [GC (Allocation Failure) 2021-06-29T17:02:36.434+0800: 0.655: [DefNew: 139633K->17472K(157248K), 0.0067071 secs] 417223K->325343K(506816K), 0.0067803 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2021-06-29T17:02:36.463+0800: 0.684: [GC (Allocation Failure) 2021-06-29T17:02:36.463+0800: 0.684: [DefNew: 157248K->157248K(157248K), 0.0000168 secs]2021-06-29T17:02:36.463+0800: 0.684: [Tenured: 307871K->313266K(349568K), 0.0376968 secs] 465119K->313266K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0377811 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:02:36.519+0800: 0.740: [GC (Allocation Failure) 2021-06-29T17:02:36.519+0800: 0.740: [DefNew: 139776K->139776K(157248K), 0.0000170 secs]2021-06-29T17:02:36.519+0800: 0.740: [Tenured: 313266K->319210K(349568K), 0.0407889 secs] 453042K->319210K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0408861 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:02:36.581+0800: 0.801: [GC (Allocation Failure) 2021-06-29T17:02:36.581+0800: 0.801: [DefNew: 139675K->139675K(157248K), 0.0000167 secs]2021-06-29T17:02:36.581+0800: 0.801: [Tenured: 319210K->312680K(349568K), 0.0393429 secs] 458885K->312680K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0394584 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:02:36.639+0800: 0.860: [GC (Allocation Failure) 2021-06-29T17:02:36.639+0800: 0.860: [DefNew: 139776K->139776K(157248K), 0.0000177 secs]2021-06-29T17:02:36.639+0800: 0.860: [Tenured: 312680K->346213K(349568K), 0.0330636 secs] 452456K->346213K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0331788 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
2021-06-29T17:02:36.692+0800: 0.913: [GC (Allocation Failure) 2021-06-29T17:02:36.692+0800: 0.913: [DefNew: 139776K->139776K(157248K), 0.0000304 secs]2021-06-29T17:02:36.692+0800: 0.913: [Tenured: 346213K->349509K(349568K), 0.0389850 secs] 485989K->350485K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0390817 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:02:36.755+0800: 0.976: [Full GC (Allocation Failure) 2021-06-29T17:02:36.755+0800: 0.976: [Tenured: 349509K->349384K(349568K), 0.0391714 secs] 506346K->349777K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0392342 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:02:36.817+0800: 1.039: [Full GC (Allocation Failure) 2021-06-29T17:02:36.818+0800: 1.039: [Tenured: 349526K->337195K(349568K), 0.0430721 secs] 506773K->337195K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0431368 secs] [Times: user=0.05 sys=0.00, real=0.04 secs] 
Heap
 def new generation   total 157248K, used 90343K [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden space 139776K,  64% used [0x00000000e0000000, 0x00000000e5839c08, 0x00000000e8880000)
  from space 17472K,   0% used [0x00000000e9990000, 0x00000000e9990000, 0x00000000eaaa0000)
  to   space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
 tenured generation   total 349568K, used 337195K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
   the space 349568K,  96% used [0x00000000eaaa0000, 0x00000000ff3eafe0, 0x00000000ff3eb000, 0x0000000100000000)
 Metaspace       used 2678K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
```

并行：
```
java -Xmx512m -Xms512m -XX:+UseParallelGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis

PS F:\github\JavaCourseCodes\01jvm> java -Xmx512m -Xms512m -XX:+UseParallelGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9779

Java HotSpot(TM) 64-Bit Server VM (25.192-b04) for windows-amd64 JRE (1.8.0_192-ea-b04), built on Aug  1 2018 20:11:41 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 16688036k(8121108k free), swap 19702692k(6506856k free)
CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=536870912 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC 
2021-06-29T17:07:25.420+0800: 0.188: [GC (Allocation Failure) [PSYoungGen: 131351K->21487K(153088K)] 131351K->48275K(502784K), 0.0102161 secs] [Times: user=0.02 sys=0.05, real=0.01 secs] 
2021-06-29T17:07:25.450+0800: 0.218: [GC (Allocation Failure) [PSYoungGen: 153071K->21499K(153088K)] 179859K->93459K(502784K), 0.0131513 secs] [Times: user=0.05 sys=0.02, real=0.01 secs] 
2021-06-29T17:07:25.483+0800: 0.251: [GC (Allocation Failure) [PSYoungGen: 153001K->21495K(153088K)] 224961K->137591K(502784K), 0.0108722 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.514+0800: 0.282: [GC (Allocation Failure) [PSYoungGen: 153079K->21499K(153088K)] 269175K->180168K(502784K), 0.0111001 secs] [Times: user=0.00 sys=0.06, real=0.01 secs] 
2021-06-29T17:07:25.546+0800: 0.314: [GC (Allocation Failure) [PSYoungGen: 153083K->21503K(153088K)] 311752K->220047K(502784K), 0.0103159 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.577+0800: 0.345: [GC (Allocation Failure) [PSYoungGen: 153087K->21485K(80384K)] 351631K->258687K(430080K), 0.0102362 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.596+0800: 0.364: [GC (Allocation Failure) [PSYoungGen: 80365K->34668K(116736K)] 317567K->278580K(466432K), 0.0047976 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.608+0800: 0.376: [GC (Allocation Failure) [PSYoungGen: 93297K->47197K(116736K)] 337209K->296714K(466432K), 0.0057967 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.622+0800: 0.390: [GC (Allocation Failure) [PSYoungGen: 106077K->57664K(116736K)] 355594K->315453K(466432K), 0.0071927 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.637+0800: 0.405: [GC (Allocation Failure) [PSYoungGen: 116544K->39771K(116736K)] 374333K->332252K(466432K), 0.0092112 secs] [Times: user=0.02 sys=0.05, real=0.01 secs] 
2021-06-29T17:07:25.646+0800: 0.414: [Full GC (Ergonomics) [PSYoungGen: 39771K->0K(116736K)] [ParOldGen: 292480K->233815K(349696K)] 332252K->233815K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0276540 secs] [Times: user=0.06 sys=0.02, real=0.03 secs] 
2021-06-29T17:07:25.684+0800: 0.452: [GC (Allocation Failure) [PSYoungGen: 58739K->20621K(116736K)] 292555K->254436K(466432K), 0.0026108 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.695+0800: 0.462: [GC (Allocation Failure) [PSYoungGen: 79415K->20609K(116736K)] 313230K->273658K(466432K), 0.0042444 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.708+0800: 0.476: [GC (Allocation Failure) [PSYoungGen: 79360K->20418K(116736K)] 332409K->292989K(466432K), 0.0044261 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:25.720+0800: 0.488: [GC (Allocation Failure) [PSYoungGen: 79298K->19466K(116736K)] 351869K->310811K(466432K), 0.0041327 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.734+0800: 0.501: [GC (Allocation Failure) [PSYoungGen: 78273K->19215K(116736K)] 369618K->329870K(466432K), 0.0054318 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2021-06-29T17:07:25.739+0800: 0.507: [Full GC (Ergonomics) [PSYoungGen: 19215K->0K(116736K)] [ParOldGen: 310655K->263662K(349696K)] 329870K->263662K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0275365 secs] [Times: user=0.08 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:25.774+0800: 0.543: [GC (Allocation Failure) [PSYoungGen: 58562K->20462K(116736K)] 322225K->284125K(466432K), 0.0023833 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.785+0800: 0.553: [GC (Allocation Failure) [PSYoungGen: 78903K->17693K(116736K)] 342566K->299926K(466432K), 0.0040432 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.798+0800: 0.566: [GC (Allocation Failure) [PSYoungGen: 76489K->17264K(116736K)] 358723K->316062K(466432K), 0.0036958 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.810+0800: 0.579: [GC (Allocation Failure) [PSYoungGen: 76144K->17506K(116736K)] 374942K->332903K(466432K), 0.0041170 secs] [Times: user=0.06 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.814+0800: 0.583: [Full GC (Ergonomics) [PSYoungGen: 17506K->0K(116736K)] [ParOldGen: 315396K->280305K(349696K)] 332903K->280305K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0281881 secs] [Times: user=0.06 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:25.851+0800: 0.619: [GC (Allocation Failure) [PSYoungGen: 58880K->18586K(116736K)] 339185K->298892K(466432K), 0.0022525 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.861+0800: 0.629: [GC (Allocation Failure) [PSYoungGen: 77261K->21977K(116736K)] 357567K->320121K(466432K), 0.0041061 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.874+0800: 0.642: [GC (Allocation Failure) [PSYoungGen: 80422K->22443K(116736K)] 378565K->340151K(466432K), 0.0051080 secs] [Times: user=0.06 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.879+0800: 0.647: [Full GC (Ergonomics) [PSYoungGen: 22443K->0K(116736K)] [ParOldGen: 317708K->297507K(349696K)] 340151K->297507K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0304477 secs] [Times: user=0.09 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:25.917+0800: 0.686: [GC (Allocation Failure) [PSYoungGen: 58826K->20696K(116736K)] 356334K->318204K(466432K), 0.0024966 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.929+0800: 0.697: [GC (Allocation Failure) [PSYoungGen: 79228K->16871K(116736K)] 376736K->333821K(466432K), 0.0039843 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.933+0800: 0.701: [Full GC (Ergonomics) [PSYoungGen: 16871K->0K(116736K)] [ParOldGen: 316949K->306543K(349696K)] 333821K->306543K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0300946 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:25.972+0800: 0.740: [GC (Allocation Failure) [PSYoungGen: 58243K->16190K(116736K)] 364786K->322733K(466432K), 0.0020647 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:25.983+0800: 0.751: [GC (Allocation Failure) [PSYoungGen: 75025K->19488K(116736K)] 381568K->341891K(466432K), 0.0041515 secs] [Times: user=0.03 sys=0.03, real=0.00 secs] 
2021-06-29T17:07:25.987+0800: 0.755: [Full GC (Ergonomics) [PSYoungGen: 19488K->0K(116736K)] [ParOldGen: 322403K->312834K(349696K)] 341891K->312834K(466432K), [Metaspace: 2672K->2672K(1056768K)], 0.0308676 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.027+0800: 0.795: [GC (Allocation Failure) [PSYoungGen: 58880K->20080K(116736K)] 371714K->332914K(466432K), 0.0023759 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:26.038+0800: 0.805: [GC (Allocation Failure) [PSYoungGen: 78960K->18254K(117760K)] 391794K->348413K(467456K), 0.0044229 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:26.042+0800: 0.810: [Full GC (Ergonomics) [PSYoungGen: 18254K->0K(117760K)] [ParOldGen: 330159K->318352K(349696K)] 348413K->318352K(467456K), [Metaspace: 2672K->2672K(1056768K)], 0.0307104 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.082+0800: 0.850: [GC (Allocation Failure) [PSYoungGen: 59647K->19324K(116736K)] 378000K->337677K(466432K), 0.0022536 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:26.093+0800: 0.860: [GC (Allocation Failure) [PSYoungGen: 79136K->38228K(115200K)] 397489K->356580K(464896K), 0.0039618 secs] [Times: user=0.06 sys=0.00, real=0.00 secs] 
2021-06-29T17:07:26.105+0800: 0.873: [GC (Allocation Failure) [PSYoungGen: 99156K->56828K(117760K)] 417508K->375893K(467456K), 0.0056323 secs] [Times: user=0.02 sys=0.02, real=0.01 secs] 
2021-06-29T17:07:26.119+0800: 0.886: [GC (Allocation Failure) [PSYoungGen: 117756K->56549K(115712K)] 436821K->392116K(465408K), 0.0073885 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T17:07:26.126+0800: 0.894: [Full GC (Ergonomics) [PSYoungGen: 56549K->0K(115712K)] [ParOldGen: 335566K->330610K(349696K)] 392116K->330610K(465408K), [Metaspace: 2672K->2672K(1056768K)], 0.0332682 secs] [Times: user=0.19 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.167+0800: 0.935: [Full GC (Ergonomics) [PSYoungGen: 58868K->0K(115712K)] [ParOldGen: 330610K->330161K(349696K)] 389478K->330161K(465408K), [Metaspace: 2672K->2672K(1056768K)], 0.0306069 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.206+0800: 0.974: [Full GC (Ergonomics) [PSYoungGen: 58856K->0K(115712K)] [ParOldGen: 330161K->331826K(349696K)] 389017K->331826K(465408K), [Metaspace: 2672K->2672K(1056768K)], 0.0342450 secs] [Times: user=0.09 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.249+0800: 1.017: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(115712K)] [ParOldGen: 331826K->332687K(349696K)] 390706K->332687K(465408K), [Metaspace: 2672K->2672K(1056768K)], 0.0332527 secs] [Times: user=0.14 sys=0.00, real=0.03 secs] 
2021-06-29T17:07:26.291+0800: 1.059: [Full GC (Ergonomics) [PSYoungGen: 58865K->0K(115712K)] [ParOldGen: 332687K->335187K(349696K)] 391553K->335187K(465408K), [Metaspace: 2672K->2672K(1056768K)], 0.0335626 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
Heap
 PSYoungGen      total 115712K, used 23643K [0x00000000f5580000, 0x0000000100000000, 0x0000000100000000)
  eden space 58880K, 40% used [0x00000000f5580000,0x00000000f6c96f98,0x00000000f8f00000)
  from space 56832K, 0% used [0x00000000fc880000,0x00000000fc880000,0x0000000100000000)
  to   space 57856K, 0% used [0x00000000f8f00000,0x00000000f8f00000,0x00000000fc780000)
 ParOldGen       total 349696K, used 335187K [0x00000000e0000000, 0x00000000f5580000, 0x00000000f5580000)
  object space 349696K, 95% used [0x00000000e0000000,0x00000000f4754f58,0x00000000f5580000)
 Metaspace       used 2678K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
```

CMS:
```
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis

PS F:\github\JavaCourseCodes\01jvm> java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnaly
sis
正在执行...
执行结束!共生成对象次数:10742

Java HotSpot(TM) 64-Bit Server VM (25.192-b04) for windows-amd64 JRE (1.8.0_192-ea-b04), built on Aug  1 2018 20:11:41 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 16688036k(8299200k free), swap 19702692k(6505500k free)
CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=536870912 -XX:MaxNewSize=178958336 -XX:MaxTenuringThreshold=6 -XX:NewSize=178958336 -XX:OldPLABSize=16 -XX:OldSize=357912576 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC 
2021-06-29T17:09:42.567+0800: 0.196: [GC (Allocation Failure) 2021-06-29T17:09:42.567+0800: 0.196: [ParNew: 139486K->17470K(157248K), 0.0088920 secs] 139486K->42098K(506816K), 0.0091923 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T17:09:42.600+0800: 0.228: [GC (Allocation Failure) 2021-06-29T17:09:42.600+0800: 0.228: [ParNew: 157190K->17472K(157248K), 0.0157508 secs] 181819K->90903K(506816K), 0.0158568 secs] [Times: user=0.01 sys=0.05, real=0.02 secs] 
2021-06-29T17:09:42.635+0800: 0.263: [GC (Allocation Failure) 2021-06-29T17:09:42.635+0800: 0.263: [ParNew: 157248K->17472K(157248K), 0.0236500 secs] 230679K->133078K(506816K), 0.0237244 secs] [Times: user=0.11 sys=0.02, real=0.02 secs] 
2021-06-29T17:09:42.679+0800: 0.307: [GC (Allocation Failure) 2021-06-29T17:09:42.679+0800: 0.307: [ParNew: 157248K->17472K(157248K), 0.0273073 secs] 272854K->181450K(506816K), 0.0273790 secs] [Times: user=0.11 sys=0.02, real=0.03 secs] 
2021-06-29T17:09:42.725+0800: 0.354: [GC (Allocation Failure) 2021-06-29T17:09:42.725+0800: 0.354: [ParNew: 157056K->17472K(157248K), 0.0240673 secs] 321035K->225406K(506816K), 0.0241438 secs] [Times: user=0.06 sys=0.00, real=0.02 secs] 
2021-06-29T17:09:42.749+0800: 0.379: [GC (CMS Initial Mark) [1 CMS-initial-mark: 207934K(349568K)] 225696K(506816K), 0.0001739 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.750+0800: 0.379: [CMS-concurrent-mark-start]
2021-06-29T17:09:42.754+0800: 0.383: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.02 sys=0.02, real=0.00 secs] 
2021-06-29T17:09:42.754+0800: 0.383: [CMS-concurrent-preclean-start]
2021-06-29T17:09:42.754+0800: 0.384: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.754+0800: 0.384: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:42.769+0800: 0.398: [GC (Allocation Failure) 2021-06-29T17:09:42.769+0800: 0.398: [ParNew: 157053K->17472K(157248K), 0.0265778 secs] 364988K->273421K(506816K), 0.0266384 secs] [Times: user=0.05 sys=0.02, real=0.03 secs] 
2021-06-29T17:09:42.815+0800: 0.444: [GC (Allocation Failure) 2021-06-29T17:09:42.815+0800: 0.444: [ParNew: 157185K->17472K(157248K), 0.0236617 secs] 413135K->317889K(506816K), 0.0237417 secs] [Times: user=0.05 sys=0.01, real=0.02 secs] 
2021-06-29T17:09:42.857+0800: 0.486: [GC (Allocation Failure) 2021-06-29T17:09:42.857+0800: 0.486: [ParNew: 157094K->157094K(157248K), 0.0000198 secs]2021-06-29T17:09:42.857+0800: 0.486: [CMS2021-06-29T17:09:42.857+0800: 0.486: [CMS-concurrent-abortable-preclean: 0.003/0.102 secs] [Times: user=0.16 sys=0.03, real=0.10 secs] 
 (concurrent mode failure): 300417K->256107K(349568K), 0.0343744 secs] 457512K->256107K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0344691 secs] [Times: user=0.05 sys=0.00, real=0.03 secs] 
2021-06-29T17:09:42.914+0800: 0.543: [GC (Allocation Failure) 2021-06-29T17:09:42.914+0800: 0.543: [ParNew: 139776K->17472K(157248K), 0.0053365 secs] 395883K->294453K(506816K), 0.0054124 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.919+0800: 0.548: [GC (CMS Initial Mark) [1 CMS-initial-mark: 276981K(349568K)] 295243K(506816K), 0.0001519 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.920+0800: 0.548: [CMS-concurrent-mark-start]
2021-06-29T17:09:42.922+0800: 0.550: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.922+0800: 0.550: [CMS-concurrent-preclean-start]
2021-06-29T17:09:42.922+0800: 0.551: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:42.922+0800: 0.551: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:42.939+0800: 0.568: [GC (Allocation Failure) 2021-06-29T17:09:42.939+0800: 0.568: [ParNew: 157248K->17469K(157248K), 0.0150891 secs] 434229K->337831K(506816K), 0.0151698 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-06-29T17:09:42.974+0800: 0.603: [GC (Allocation Failure) 2021-06-29T17:09:42.974+0800: 0.603: [ParNew: 157245K->157245K(157248K), 0.0000196 secs]2021-06-29T17:09:42.974+0800: 0.603: [CMS2021-06-29T17:09:42.974+0800: 0.603: [CMS-concurrent-abortable-preclean: 0.002/0.052 secs] [Times: user=0.09 sys=0.02, real=0.05 secs] 
 (concurrent mode failure): 320362K->284678K(349568K), 0.0394368 secs] 477607K->284678K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0395303 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:09:43.034+0800: 0.663: [GC (Allocation Failure) 2021-06-29T17:09:43.034+0800: 0.663: [ParNew: 139776K->17472K(157248K), 0.0069205 secs] 424454K->335441K(506816K), 0.0069784 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T17:09:43.042+0800: 0.670: [GC (CMS Initial Mark) [1 CMS-initial-mark: 317969K(349568K)] 338331K(506816K), 0.0001690 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.042+0800: 0.670: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.044+0800: 0.672: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.044+0800: 0.672: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.044+0800: 0.673: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.044+0800: 0.673: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.044+0800: 0.673: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.044+0800: 0.673: [GC (CMS Final Remark) [YG occupancy: 39921 K (157248 K)]2021-06-29T17:09:43.045+0800: 0.673: [Rescan (parallel) , 0.0003200 secs]2021-06-29T17:09:43.045+0800: 0.673: [weak refs processing, 0.0000141 secs]2021-06-29T17:09:43.045+0800: 0.673: [class unloading, 0.0001908 secs]2021-06-29T17:09:43.045+0800: 0.673: [scrub symbol table, 0.0003041 secs]2021-06-29T17:09:43.045+0800: 0.674: [scrub string table, 0.0001066 secs][1 CMS-remark: 317969K(349568K)] 357891K(506816K), 0.0010231 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.046+0800: 0.674: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.046+0800: 0.674: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.046+0800: 0.675: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.046+0800: 0.675: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.061+0800: 0.690: [GC (Allocation Failure) 2021-06-29T17:09:43.061+0800: 0.690: [ParNew: 157248K->17466K(157248K), 0.0081887 secs] 436042K->337116K(506816K), 0.0082612 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T17:09:43.070+0800: 0.698: [GC (CMS Initial Mark) [1 CMS-initial-mark: 319650K(349568K)] 337696K(506816K), 0.0001755 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.070+0800: 0.699: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.072+0800: 0.701: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.072+0800: 0.701: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.073+0800: 0.701: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.073+0800: 0.701: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.073+0800: 0.701: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.073+0800: 0.702: [GC (CMS Final Remark) [YG occupancy: 34301 K (157248 K)]2021-06-29T17:09:43.073+0800: 0.702: [Rescan (parallel) , 0.0003537 secs]2021-06-29T17:09:43.074+0800: 0.702: [weak refs processing, 0.0000282 secs]2021-06-29T17:09:43.074+0800: 0.702: [class unloading, 0.0001705 secs]2021-06-29T17:09:43.074+0800: 0.702: [scrub symbol table, 0.0002974 secs]2021-06-29T17:09:43.074+0800: 0.702: [scrub string table, 0.0001052 secs][1 CMS-remark: 319650K(349568K)] 353951K(506816K), 0.0010431 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.074+0800: 0.703: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.075+0800: 0.703: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.075+0800: 0.703: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.075+0800: 0.704: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.090+0800: 0.720: [GC (Allocation Failure) 2021-06-29T17:09:43.090+0800: 0.720: [ParNew: 157242K->17467K(157248K), 0.0143197 secs] 444517K->352209K(506816K), 0.0143930 secs] [Times: user=0.06 sys=0.00, real=0.02 secs] 
2021-06-29T17:09:43.105+0800: 0.734: [GC (CMS Initial Mark) [1 CMS-initial-mark: 334741K(349568K)] 355090K(506816K), 0.0002606 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.105+0800: 0.735: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.107+0800: 0.737: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.107+0800: 0.737: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.108+0800: 0.737: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.108+0800: 0.737: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.108+0800: 0.737: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.108+0800: 0.737: [GC (CMS Final Remark) [YG occupancy: 38648 K (157248 K)]2021-06-29T17:09:43.108+0800: 0.737: [Rescan (parallel) , 0.0004002 secs]2021-06-29T17:09:43.108+0800: 0.738: [weak refs processing, 0.0000124 secs]2021-06-29T17:09:43.108+0800: 0.738: [class unloading, 0.0002816 secs]2021-06-29T17:09:43.109+0800: 0.738: [scrub symbol table, 0.0003005 secs]2021-06-29T17:09:43.109+0800: 0.738: [scrub string table, 0.0000980 secs][1 CMS-remark: 334741K(349568K)] 373390K(506816K), 0.0011549 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.109+0800: 0.739: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.110+0800: 0.739: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.110+0800: 0.739: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.110+0800: 0.739: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.128+0800: 0.757: [GC (Allocation Failure) 2021-06-29T17:09:43.128+0800: 0.757: [ParNew: 157093K->157093K(157248K), 0.0000182 secs]2021-06-29T17:09:43.128+0800: 0.757: [CMS: 299724K->316611K(349568K), 0.0422990 secs] 456818K->316611K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0423869 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2021-06-29T17:09:43.171+0800: 0.800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 316611K(349568K)] 316991K(506816K), 0.0002090 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.171+0800: 0.800: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.173+0800: 0.802: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.173+0800: 0.802: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.174+0800: 0.803: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.174+0800: 0.803: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.189+0800: 0.818: [GC (Allocation Failure) 2021-06-29T17:09:43.189+0800: 0.818: [ParNew: 139258K->139258K(157248K), 0.0000211 secs]2021-06-29T17:09:43.189+0800: 0.818: [CMS2021-06-29T17:09:43.189+0800: 0.818: [CMS-concurrent-abortable-preclean: 0.001/0.015 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
 (concurrent mode failure): 316611K->322092K(349568K), 0.0475524 secs] 455870K->322092K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0476535 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-06-29T17:09:43.256+0800: 0.885: [GC (Allocation Failure) 2021-06-29T17:09:43.256+0800: 0.885: [ParNew: 139776K->139776K(157248K), 0.0000187 secs]2021-06-29T17:09:43.256+0800: 0.885: [CMS: 322092K->330357K(349568K), 0.0434370 secs] 461868K->330357K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0435288 secs] [Times: user=0.05 sys=0.00, real=0.04 secs] 
2021-06-29T17:09:43.299+0800: 0.928: [GC (CMS Initial Mark) [1 CMS-initial-mark: 330357K(349568K)] 333278K(506816K), 0.0002049 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.300+0800: 0.929: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.302+0800: 0.931: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.302+0800: 0.931: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.302+0800: 0.931: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.302+0800: 0.931: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.302+0800: 0.931: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.303+0800: 0.931: [GC (CMS Final Remark) [YG occupancy: 29488 K (157248 K)]2021-06-29T17:09:43.303+0800: 0.931: [Rescan (parallel) , 0.0003602 secs]2021-06-29T17:09:43.303+0800: 0.932: [weak refs processing, 0.0000145 secs]2021-06-29T17:09:43.303+0800: 0.932: [class unloading, 0.0001863 secs]2021-06-29T17:09:43.303+0800: 0.932: [scrub symbol table, 0.0002982 secs]2021-06-29T17:09:43.303+0800: 0.932: [scrub string table, 0.0001421 secs][1 CMS-remark: 330357K(349568K)] 359845K(506816K), 0.0010708 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.304+0800: 0.932: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.304+0800: 0.933: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.304+0800: 0.933: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.304+0800: 0.933: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.320+0800: 0.949: [GC (Allocation Failure) 2021-06-29T17:09:43.320+0800: 0.949: [ParNew: 139776K->139776K(157248K), 0.0000194 secs]2021-06-29T17:09:43.320+0800: 0.949: [CMS: 329663K->335316K(349568K), 0.0448151 secs] 469439K->335316K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0449055 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-06-29T17:09:43.366+0800: 0.994: [GC (CMS Initial Mark) [1 CMS-initial-mark: 335316K(349568K)] 335556K(506816K), 0.0001711 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.366+0800: 0.994: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.368+0800: 0.996: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.368+0800: 0.997: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.368+0800: 0.997: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.368+0800: 0.997: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.368+0800: 0.997: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.369+0800: 0.997: [GC (CMS Final Remark) [YG occupancy: 23006 K (157248 K)]2021-06-29T17:09:43.369+0800: 0.997: [Rescan (parallel) , 0.0003288 secs]2021-06-29T17:09:43.369+0800: 0.998: [weak refs processing, 0.0000130 secs]2021-06-29T17:09:43.369+0800: 0.998: [class unloading, 0.0001899 secs]2021-06-29T17:09:43.369+0800: 0.998: [scrub symbol table, 0.0002963 secs]2021-06-29T17:09:43.369+0800: 0.998: [scrub string table, 0.0001450 secs][1 CMS-remark: 335316K(349568K)] 358322K(506816K), 0.0010545 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.370+0800: 0.998: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.370+0800: 0.999: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.370+0800: 0.999: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.371+0800: 0.999: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.385+0800: 1.014: [GC (Allocation Failure) 2021-06-29T17:09:43.385+0800: 1.014: [ParNew: 139554K->139554K(157248K), 0.0000178 secs]2021-06-29T17:09:43.385+0800: 1.014: [CMS: 335316K->337146K(349568K), 0.0448380 secs] 474871K->337146K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0449233 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-06-29T17:09:43.430+0800: 1.059: [GC (CMS Initial Mark) [1 CMS-initial-mark: 337146K(349568K)] 337517K(506816K), 0.0002274 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.431+0800: 1.059: [CMS-concurrent-mark-start]
2021-06-29T17:09:43.433+0800: 1.061: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.433+0800: 1.061: [CMS-concurrent-preclean-start]
2021-06-29T17:09:43.433+0800: 1.062: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.433+0800: 1.062: [CMS-concurrent-abortable-preclean-start]
2021-06-29T17:09:43.433+0800: 1.062: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.433+0800: 1.062: [GC (CMS Final Remark) [YG occupancy: 21677 K (157248 K)]2021-06-29T17:09:43.433+0800: 1.062: [Rescan (parallel) , 0.0003061 secs]2021-06-29T17:09:43.434+0800: 1.062: [weak refs processing, 0.0000451 secs]2021-06-29T17:09:43.434+0800: 1.062: [class unloading, 0.0001694 secs]2021-06-29T17:09:43.434+0800: 1.062: [scrub symbol table, 0.0002950 secs]2021-06-29T17:09:43.434+0800: 1.063: [scrub string table, 0.0001052 secs][1 CMS-remark: 337146K(349568K)] 358824K(506816K), 0.0009871 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.434+0800: 1.063: [CMS-concurrent-sweep-start]
2021-06-29T17:09:43.435+0800: 1.063: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.435+0800: 1.063: [CMS-concurrent-reset-start]
2021-06-29T17:09:43.435+0800: 1.064: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.451+0800: 1.079: [GC (Allocation Failure) 2021-06-29T17:09:43.451+0800: 1.079: [ParNew: 139592K->139592K(157248K), 0.0000187 secs]2021-06-29T17:09:43.451+0800: 1.079: [CMS: 337072K->342325K(349568K), 0.0498049 secs] 476664K->342325K(506816K), [Metaspace: 2672K->2672K(1056768K)], 0.0498930 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-06-29T17:09:43.500+0800: 1.129: [GC (CMS Initial Mark) [1 CMS-initial-mark: 342325K(349568K)] 342937K(506816K), 0.0002608 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T17:09:43.500+0800: 1.130: [CMS-concurrent-mark-start]
Heap
 par new generation   total 157248K, used 6176K [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden space 139776K,   4% used [0x00000000e0000000, 0x00000000e06083e0, 0x00000000e8880000)
  from space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
  to   space 17472K,   0% used [0x00000000e9990000, 0x00000000e9990000, 0x00000000eaaa0000)
 concurrent mark-sweep generation total 349568K, used 342325K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2678K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K

```

G1: 

```
java -Xmx512m -Xms512m -XX:+UseG1GC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis

PS F:\github\JavaCourseCodes\01jvm> java -Xmx512m -Xms512m -XX:+UseG1GC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis
正在执行...
执行结束!共生成对象次数:10563

日志见01jvm/g1-gc.log
```
2.（选做）使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

java -jar -Xmx512m -Xms512m gateway-server-0.0.1-SNAPSHOT.jar

sb -u http://localhost:8088/api/hello  -c 20 -N 30
```
PS F:\github\JavaCourseCodes> sb -u http://localhost:8088/api/hello  -c 20 -N 30
Starting at 2021/6/30 8:56:43
[Press C to stop the test]
113501  (RPS: 3253.3)                   
---------------Finished!----------------
Finished at 2021/6/30 8:57:18 (took 00:00:35.0619953)
Status 200:    113508

RPS: 3642.5 (requests/second)
Max: 92ms
Min: 0ms
Avg: 0.2ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 0ms
  90%   below 0ms
  95%   below 1ms
  98%   below 3ms
  99%   below 4ms
99.9%   below 10ms

```

3.（选做）如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。
```
```
4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。
```
```
5.（选做）运行课上的例子，以及 Netty 的例子，分析相关现象。

一：压测HttpServer01,02,03三个程序：
1. **使用的参数是20并发，40无法启动**
2. 使用线程池比创建线程的RPS高（线程复用减少了线程创建和销毁的消耗）
3. 但是，**单线程串行消费RPS>线程池>多线程，这个和课件有较大出入？未弄清楚原因，还望老师解答**

测试命令和日志：
 sb -u http://localhost:8801 -c 20 -N 30
```
PS F:\github\JavaCourseCodes> sb -u http://localhost:8801 -c 20 -N 30
Starting at 2021/6/30 9:06:39
[Press C to stop the test]
81689   (RPS: 2330.8)                   
---------------Finished!----------------
Finished at 2021/6/30 9:07:14 (took 00:00:35.2723173)
Status 303:    6615
Status 200:    75074

RPS: 2616.9 (requests/second)
Max: 82ms
Min: 0ms
Avg: 0.8ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 1ms
  90%   below 3ms
  95%   below 5ms
  98%   below 8ms
  99%   below 10ms
99.9%   below 21ms
```
sb -u http://localhost:8802 -c 20 -N 30
```
PS F:\github\JavaCourseCodes> sb -u http://localhost:8802 -c 20 -N 30
Starting at 2021/6/30 9:04:19
[Press C to stop the test]
63152   (RPS: 1804.9)                   
---------------Finished!----------------
Finished at 2021/6/30 9:04:55 (took 00:00:35.1957415)
Status 200:    63046
Status 303:    106

RPS: 2024.3 (requests/second)
Max: 180ms
Min: 0ms
Avg: 2.9ms

  50%   below 1ms
  60%   below 2ms
  70%   below 4ms
  80%   below 5ms
  90%   below 7ms
  95%   below 9ms
  98%   below 12ms
  99%   below 16ms
99.9%   below 65ms
```
sb -u http://localhost:8803 -c 20 -N 30
```
PS F:\github\JavaCourseCodes> sb -u http://localhost:8803 -c 20 -N 30
Starting at 2021/6/30 9:05:41
[Press C to stop the test]
78433   (RPS: 2248.9)                   
---------------Finished!----------------
Finished at 2021/6/30 9:06:16 (took 00:00:34.9301078)
Status 200:    71332
Status 303:    7112

RPS: 2527.5 (requests/second)
Max: 107ms
Min: 0ms
Avg: 1.1ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 2ms
  90%   below 4ms
  95%   below 6ms
  98%   below 9ms
  99%   below 11ms
99.9%   below 25ms
```
二：netty相关演示：

**netty压测 c15 ,c20无法启动** 
```
PS F:\github\JavaCourseCodes> sb -u http://localhost:8808 -c 15 -N 30
Starting at 2021/6/30 9:15:46
[Press C to stop the test]
134089  (RPS: 3838.9)                   
---------------Finished!----------------
Finished at 2021/6/30 9:16:22 (took 00:00:35.1581711)
Status 200:    134093

RPS: 4295.2 (requests/second)
Max: 54ms
Min: 0ms
Avg: 0.1ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 0ms
  90%   below 0ms
  95%   below 0ms
  98%   below 1ms
  99%   below 2ms
99.9%   below 5ms

```
6.（必做）写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub
```
```