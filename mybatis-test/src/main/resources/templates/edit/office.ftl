<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="mobile-web-app-capable" content="yes" />
    <title>ONLYOFFICE</title>
    <style>
        html {
            height: 100%;
            width: 100%;
        }

        body {
            background: #fff;
            color: #333;
            font-family: Arial, Tahoma,sans-serif;
            font-size: 12px;
            font-weight: normal;
            height: 100%;
            margin: 0;
            overflow-y: hidden;
            padding: 0;
            text-decoration: none;
        }

        .form {
            height: 100%;
        }

        div {
            margin: 0;
            padding: 0;
        }
    </style>
    <script type="text/javascript" src="${model.docServiceApiUrl}"></script>

    <script type="text/javascript">
        var docEditor;
        var config = {
            "type": "desktop",
            // word:text document(.doc,.txt,.docx,.pdf)
            // cell:spreadsheet(.csv,.xls)
            // slide:presentation(.ppt,.pptx)
            "documentType": "${model.documentType}",
            "width": "100%",
            "height": "100%",
            "token": "",
            "document": {
                "title": "${model.fileName}",
                //该url是onlyoffice下载文档的路径，注意这个url是onlyoffice容器可达的路径，不然你打开office会告诉你下载不了。
                "url": "${model.downloadUrl}",
                "fileType": "${model.fileType}",
                //key是onlyoffice下载文档格式化后存储到onlyoffice里面的key值，下次读取相同key值得文档时，不会再通过url加载。
                "key": "${model.key}",
                //一些授权
                "permissions": {
                    "comment": false,
                    "copy": true,
                    "download": false,
                    "edit": false,
                    "print": false,
                    "fillForms": true,
                    "modifyFilter": true,
                    "modifyContentControl": true,
                    "review": false,
                    "reviewGroups": null,
                    "commentGroups": {}
                }
            },
            "editorConfig": {
                // edit:编辑模式 view：预览模式
                "mode": "view",
                //en-ch 英文模式/zh-CN 中文模式
                "lang": "zh-CN",
                "location": "zh-CN",
                "canCoAuthoring": false,
                //文档编辑的回调，在编辑完成后，关闭该页面后的10S左右，onlyoffice服务会通过该接口将编辑后的文档流推送过来
                "callbackUrl": "${model.saveUrl}",
                "user": {
                    "id": "${model.userEmail}",
                    "name": "${model.userName}"
                },
                "customization": {
                    "about": false,
                    "chat": false,
                    "comments": false,
                    "feedback": false,
                    "forcesave": false,
                    "help": false,
                    "goback": {
                        "url": ""
                    },
                    "plugins": false,
                    "logo": {
                        "visible": false,
                    },
                    "feedback": {
                        "visible": false,
                    },
                    "close":false,
                    "submitForm": true
                },
                "canRequestEditRights": true
            },
            "events":{},
            "frameEditorId":"iframeEditor"
        }

        var сonnectEditor = function () {
            docEditor = new DocsAPI.DocEditor("iframeEditor", config);
        };

        if (window.addEventListener) {
            window.addEventListener("load", сonnectEditor);
        } else if (window.attachEvent) {
            window.attachEvent("load", сonnectEditor);
        }
    </script>

</head>
<body>
<div class="form">
    <div id="iframeEditor"></div>
</div>
</body>
</html>