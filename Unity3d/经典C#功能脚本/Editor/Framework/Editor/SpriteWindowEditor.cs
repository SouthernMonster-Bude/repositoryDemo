using System.Collections.Generic;
using System.IO;
using System.Text;
using UnityEditor;
using UnityEngine;
public class SpriteWindowEditor : EditorWindow
{
    [MenuItem("Manager/Sprite")]
    static void CreateWindow()
    {
        //此方法创建的窗口不可伸缩
        //Rect rect = new Rect(400,400,600,600);
        //AudioWindowEditor audioWindow = EditorWindow.GetWindowWithRect(typeof(AudioWindowEditor),rect) as AudioWindowEditor;
        //可伸缩窗口
        SpriteWindowEditor spriteWindow = EditorWindow.GetWindow<SpriteWindowEditor>("音频管理");
        spriteWindow.Show();
    }
    private string _atlasPath;
    private string _texturePath;
    GameObject targetGo = null;
    string subPath = "";
    string path = "";
    SpriteManager spriteManager;
    private void Awake()
    {
        spriteManager = new SpriteManager();
    }
    void OnGUI()
    {
        Debug.LogWarning("OnGUI");
        //拖拽GameObject示例
        /*targetGo = (GameObject)EditorGUILayout.ObjectField(targetGo, typeof(GameObject), true);
        subPath = targetGo == null ? subPath : targetGo.name;
        EditorGUILayout.LabelField(string.Format("保存路径output path:{0}", Path.Combine(path, subPath)));*/

        //_atlasPath = EditorGUILayout.TextField("AtlasPath", _atlasPath);
        //_texturePath = EditorGUILayout.TextField("TexturePath", _texturePath);
        EditorGUILayout.LabelField("Atlas保存路径");
        Rect rect = EditorGUILayout.GetControlRect(GUILayout.Width(300));
        _atlasPath = EditorGUI.TextField(rect, _atlasPath);

        EditorGUILayout.LabelField("img存放路径");
        Rect rect2 = EditorGUILayout.GetControlRect(GUILayout.Width(300));
        _texturePath = EditorGUI.TextField(rect2, _texturePath);

        //如果鼠标正在拖拽中或拖拽结束时，并且鼠标所在位置在文本输入框内  
        if (Event.current.type == EventType.DragUpdated
          || Event.current.type == EventType.DragExited)
        {
            //改变鼠标的外表  
            DragAndDrop.visualMode = DragAndDropVisualMode.Generic;
            if (rect.Contains(Event.current.mousePosition))
            {
                if (DragAndDrop.paths != null && DragAndDrop.paths.Length > 0)
                {
                    _atlasPath = DragAndDrop.paths[0];
                }
            }
            if (rect2.Contains(Event.current.mousePosition))
            {
                if (DragAndDrop.paths != null && DragAndDrop.paths.Length > 0)
                {
                    _texturePath = DragAndDrop.paths[0];
                }
            }

            
            
        }
        if (_atlasPath!=null&&_texturePath != null&&GUILayout.Button("生成Altas"))
        {
            spriteManager.AutoSetAtlas(_atlasPath, _texturePath);
        };


        //targetGo = (GameObject)EditorGUILayout.ObjectField(targetGo, typeof(GameObject), true);
        //subPath = targetGo == null ? subPath : targetGo.name;
        //EditorGUILayout.LabelField(string.Format("保存路径output path:{0}", Path.Combine(path, subPath)));
        //获得一个长300的框  
        //Rect rect = EditorGUILayout.GetControlRect(GUILayout.Width(300));
        //将上面的框作为文本输入框  
        //path = EditorGUI.TextField(rect, path);
        //subPath = EditorGUILayout.TextField(subPath);

        //如果鼠标正在拖拽中或拖拽结束时，并且鼠标所在位置在文本输入框内  
        /*if ((Event.current.type == EventType.DragUpdated
          || Event.current.type == EventType.DragExited)
          && rect.Contains(Event.current.mousePosition))
        {
            //改变鼠标的外表  
            DragAndDrop.visualMode = DragAndDropVisualMode.Generic;
            if (DragAndDrop.paths != null && DragAndDrop.paths.Length > 0)
            {
                path = DragAndDrop.paths[0];
            }
        }*/

    }
   

}

