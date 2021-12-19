package org.xw.jvm;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/*
 *
 * @author xuwei
 * @date 2021/12/19
 * @return
 **/
//解析命令行
public class Cmd {
    //只要有参就解析成true
    @Parameter(names={"-?","-help"},description = "打印帮助信息",order=3,help=true)
    boolean helpFlag=false;
    @Parameter(names={"-version"},description = "打印版本信息",order=3,help=true)
    boolean versionFlag=false;
    @Parameter(names={"-cp"},description = "打印路径信息",order=3,help=true)
    String classpath;
    @Parameter(description = "主类信息和参数")
    List<String> mainClassAndArgs;

    boolean ok;
    /*
     * 
     * @author xuwei
     * @date 2021/12/19 
     * @return
     **/
    String getMainClass(){
        String mainClass=null;
        if(null!=mainClassAndArgs)
            mainClass=mainClassAndArgs.get(0);
        return mainClass;
    }

    String getArgs(){
        return mainClassAndArgs!=null? mainClassAndArgs.get(1):null;
    }
    //对命令行解析
    static Cmd parse(String[] argv){
        Cmd args =new Cmd();
        JCommander cmd = JCommander.newBuilder().addObject(args).build();
        cmd.parse(argv);
        args.ok=true;
        return args;
    }
}
