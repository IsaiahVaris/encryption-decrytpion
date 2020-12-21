# encription-decryption

### Encrypt and decrypt messages using a simple numeric cipher as key and various command line arguments to determine the exact action to be carried out<br />
Legend:<br />
-mode : specifies whether an encrytpion(enc) or decrytption(dec) operation is to be carried out.<br />
-in : specifies a file from which data for the operation is to be read.<br />
-out: specifies a file to which the result from the operation is to be written.<br />
-data: specifies explicit the data to be encrypted/decrypted.<br />
-key: specifies the number by which each character should be shifted in the encryption/decrytpion process.<br />
-alg: determines whether a unicode or shift algorithm is to be used during the operation.

Examples<br />

Example 1<br />
java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode <br />
This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.<br />
<br />
Example 2<br />
Input:<br />
java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode<br />
Output:<br />
\jqhtrj%yt%m~ujwxpnqq&<br />
<br />
Example 3<br />
Input:<br />
java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec<br />
Output:<br />
Welcome to hyperskill!<br />
<br />
Example 4:<br />
Input:<br />
java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc<br />
Output:<br />
Bjqhtrj yt mdujwxpnqq!<br />
<br />
Example 5:<br />
Input:<br />
java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec<br />
Output:<br />
Welcome to hyperskill!
