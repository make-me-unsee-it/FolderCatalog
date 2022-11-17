package com.melarossa.hryshkin;

import com.melarossa.hryshkin.models.FileSystem;

public class Demo {
    public static void main(String[] args) {
        FileSystem mySystem = FileSystem.getInstance();
        mySystem.createEntity("root/file.txt");
        mySystem.createEntity("root/file.txt");
        mySystem.createEntity("root/file2.txt");
        mySystem.createEntity("root/newFolder/file3.txt");
        mySystem.createEntity("root/newFolder/file4.txt");
        mySystem.createEntity("file4.txt");
        mySystem.createEntity("root/newFolder3/someOtherFolder/titanic.mp3");
        mySystem.createEntity("root/newFolderEMPTY");
        mySystem.createEntity("root/newFolderEMPTY");
        mySystem.createEntity("windows/system32/macron.dll");
        mySystem.createEntity("windows/program files");
        mySystem.createEntity("windows/program files/x86/macromedia/flash player/uninstall.dll");
        mySystem.createEntity("windows/program files/x86/not_used_x86.txt");
        mySystem.createEntity("root/file2.txt");
        mySystem.createEntity("root/file1.txt");
        mySystem.createEntity("abs/file1.txt");
        mySystem.createEntity("root/bestHits/no_music.txt");
        mySystem.print();
    }
}
