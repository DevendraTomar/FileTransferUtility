# FileTransferUtility
Utility that transfers file from your local machine to remote machine using SFTP


<b>Project : FileTransferUtility</b><br/>

<b>Motivation:</b> <br/>
The idea behind this project was to enable rapid deployment of binaries in Development/QA Environments. <br/>
The solution uses SFTP protocol to transfer files.<br/>

<b>Technologies Used:</b><br/>
Java<br/>
Apache Maven<br/>
Jsch library<br/>

<b>Installation:</b><br/>
The project is a Maven project , hence the user would require maven binaries to build the solution. (Maven 3.0+)<br/>

<b>How To Use:</b><br/>
Once the project is build, you will find following jars in the target folder :<br/>
a) FileTransferUtility.jar (Source Code Jar) <br/>
b) FileTransferUtility-jar-with-dependencies.jar (Executable Jar)<br/>

i) Navigate to src/main/resources folder inside the project , there will be a file named config.json present in the folder.
Copy <b>config.json</b> , <b>FileTransferUtility-jar-with-dependencies.jar</b> and place the same in a seperate folder (Ex: temp).
<br/>

<ul>
<li>temp -> config.json</li>
<li>temp -> FileTransferUtility-jar-with-dependencies.jar</li>
</ul>
<br/>

ii) Create a folder with name conf inside the seperate folder (temp) and place config.json file inside that folder.<br/>
<ul>
<li>temp -> <b>conf</b>->config.json</li>
<li>temp -> FileTransferUtility-jar-with-dependencies.jar</li>
</ul>

<br/>
iii) In order to initiate the file job :<br/>
<b>java -jar FileTransferUtility-jar-with-dependencies.jar [qa/dev] </b><br/>
<br/>
iv) Based on the configuration set in the config.json file qa or dev section would get picked up and processed.<br/>

<br/>
<b>Configure config.json :</b><br/>


{ "dev": [{ "hostname": "<hostname/ip>", "username": "<username>", "password": "<password>", "target_dir": "<target-directory>, if target-directory if not present , the system will create the same and then transfer", "files": [{ "source_file": "<absolute-path-of-the-source-file-that-we-need-to-transfer>" }, { "source_file": "<absolute-path-of-the-2nd-source-file-that-we-need-to-transfer>" }] }], "qa": [{ "hostname": "host1", "username": "user1", "password": "pass1", "target_dir": "/home/admin/1", "files": [{ "source_file": "D:/abc.txt" }] }, { "hostname": "host2", "username": "user2", "password": "pass2", "target_dir": "/home/admin/1", "files": [{ "source_file": "D:/abc.txt" }] }] }



