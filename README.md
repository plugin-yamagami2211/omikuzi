# Omikuzi
おみくじ的なことができるプラグインです。  

# おみくじ結果
とりあえず、エフェクトを付与します。  
付与時間、レベルはコンフィグから変更可能です。

|  #  |  内容  |
| ---- | ---- |
|  0  |  おみくじを引くのに失敗したよ。あーあ。  |
|  1  |  移動速度上昇  |
|  2  |  移動速度減少  |
|  3  |  採掘速度上昇  |
|  4  |  採掘速度減少  |
|  5  |  攻撃力上昇  |
|  以下  |  未実装  |

## エフェクト効果の変更
コンフィグの``EffectTime``と``EffectLevel``で変更できます。

``EffectTime``: 効果時間を**秒数**で指定します。  
プラグイン側でTickに計算するので、Tick指定する必要はありません。  
あまりにも膨大な秒数にするとエラーを吐く可能性があります。

``EffectLevel``: 効果レベルを指定します。  
実際の効果レベルは 指定した数字 **+1** になります。  
例えば、4の場合、効果レベルは **5** になります。  
レベル1を指定する場合は 0 と入力します。  
多分レベルのマックスが127ぐらいだったはずです。
