using System.Collections.Generic;
using System.IO;
using System.Text;
using UnityEditor;
using UnityEngine;

public class AudioWindowEditor : EditorWindow
{
    [MenuItem("Manager/Audio")]
    static void CreateWindow()
    {
        //此方法创建的窗口不可伸缩
        //Rect rect = new Rect(400,400,600,600);
        //AudioWindowEditor audioWindow = EditorWindow.GetWindowWithRect(typeof(AudioWindowEditor),rect) as AudioWindowEditor;
        //可伸缩窗口
        AudioWindowEditor audioWindow = EditorWindow.GetWindow<AudioWindowEditor>("音频管理");
        audioWindow.Show();
    }
    private string audioName;
    private string audioPath;
    private Dictionary<string,string> audioDict = new Dictionary<string, string>();
    private string savePath;
    private void Awake()
    {
        savePath = Application.dataPath + "/Framework/Res/";
        LoadAudioList();
    }
    void OnGUI()
    {
        Debug.LogWarning("OnGUI");
        GUILayout.Label("路径文件将保存在");
        GUILayout.Label(Application.dataPath + "/Framework/Res");
        //EditorGUILayout.TextField("输入文字", text);
        //GUILayout.TextField("输入文字2");
        //列表显示
        GUILayout.Label("音效列表");
        GUILayout.BeginHorizontal();
        GUILayout.Label("audio name");
        GUILayout.Label("audio path");
        GUILayout.Label("operation");
        GUILayout.EndHorizontal();
        foreach (string key in audioDict.Keys)
        {
            string value;
            audioDict.TryGetValue(key,out value);
            EditorGUILayout.BeginHorizontal();
            GUILayout.Label(key);
            GUILayout.Label(value);
            if (GUILayout.Button("删除"))
            {
                audioDict.Remove(key);
                return;
            };
            EditorGUILayout.EndHorizontal();
        }

        audioName = EditorGUILayout.TextField("文件名", audioName);
        audioPath = EditorGUILayout.TextField("文件路径", audioPath);
        if (GUILayout.Button("添加音效"))
        {
            object o = Resources.Load(audioPath);
            if (o == null)
            {
                Debug.LogWarning("音效不存在于 " + audioPath);
                audioPath = "";
            }
            else
            {
                if (audioDict.ContainsKey(audioName))
                {
                    Debug.LogWarning("音效已经添加 " + audioName);
                    audioName = "";
                }
                else
                {
                    audioDict.Add(audioName, audioPath);
                }
                
            }
        };
 
    
    
    
    
    
    
    
    }
    private void SaveAudioList()
    {
        StringBuilder sb = new StringBuilder();
        foreach (string key in audioDict.Keys)
        {
            string value;
            audioDict.TryGetValue(key, out value);
            sb.Append(key + ":" + value+"\n");
        }
        sb.Remove(sb.Length-1,1);
        string filename = savePath + "audioList.txt";
        File.WriteAllText(filename, sb.ToString());
        Debug.LogWarning("音效列表已经保存在 " + filename);
    }
    private void LoadAudioList()
    {
        string filename = savePath + "audioList.txt";
        if (!File.Exists(filename)) return;
        string[] lines = File.ReadAllLines(filename);
        foreach (string line in lines)
        {
            if (string.IsNullOrEmpty(line)) continue;
            string[] keyvalue = line.Split(':');
            audioDict.Add(keyvalue[0],keyvalue[1]);

        }
    }
    
}
