package org.xw.jvm;

public class Main {
    public static void main(String[] args){
        Cmd cmd =Cmd.parse(args);
        if(!cmd.ok||cmd.helpFlag) {
            System.out.println("Usage: java [-options] class [args...]");
        }else if(cmd.versionFlag) {
            System.out.println("\"java version \"1.8.0\"\"");
        }else{
            System.out.printf("classpath:%s class:%s args:%s\n", cmd.classpath, cmd.getMainClass(), cmd.getArgs());
        }
    }
}
