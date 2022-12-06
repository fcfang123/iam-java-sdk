
![](docs/resource/img/bk_iam_zh.png)
---

[![license](https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](https://github.com/TencentBlueKing/iam-java-sdk/blob/master/LICENSE.txt) [![Release Version](https://img.shields.io/badge/release-0.0.4-brightgreen.svg)](https://github.com/TencentBlueKing/iam-go-sdk/releases) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/TencentBlueKing/iam-go-sdk/pulls)

[(English Documents Available)](readme_en.md)

## Overview

iam-java-sdk 是蓝鲸权限中心(BK-IAM)提供的用于快速接入权限体系的java SDK

## Features

- 鉴权支持: IsAllowed
- 单个操作批量资源鉴权: BatchIsAllowed
- 资源反向拉取接口basic auth鉴权: IsBasicAuthAllowed  / 以及basic auth middleware
- 获取系统Token: GetToken
- 支持反向拉取框架 dispatcher/provider interface

## Getting started

### Installation

### maven
```
<dependency>
  <groupId>com.tencent.bk.sdk</groupId>
  <artifactId>iam-java-sdk</artifactId>
  <version>${version}</version>
</dependency>
```

#### gradle
```
implementation "com.tencent.bk.sdk:iam-java-sdk:${version}"
```

### Usage

TODO

## Roadmap

- [版本日志](release.md)

## IAM Repos

- [TencentBlueKing/bk-iam](https://github.com/TencentBlueKing/bk-iam)
- [TencentBlueKing/bk-iam-saas](https://github.com/TencentBlueKing/bk-iam-saas)
- [TencentBlueKing/bk-iam-search-engine](https://github.com/TencentBlueKing/bk-iam-search-engine)
- [TencentBlueKing/bk-iam-cli](https://github.com/TencentBlueKing/bk-iam-cli)
- [TencentBlueKing/iam-python-sdk](https://github.com/TencentBlueKing/iam-python-sdk)
- [TencentBlueKing/iam-go-sdk](https://github.com/TencentBlueKing/iam-go-sdk)
- [TencentBlueKing/iam-php-sdk](https://github.com/TencentBlueKing/iam-php-sdk)
- [TencentBlueKing/iam-java-sdk](https://github.com/TencentBlueKing/iam-java-sdk)

## Support

- [蓝鲸论坛](https://bk.tencent.com/s-mart/community)
- [蓝鲸 DevOps 在线视频教程](https://bk.tencent.com/s-mart/video/)
- 联系我们，技术交流QQ群：

<img src="https://github.com/Tencent/bk-PaaS/raw/master/docs/resource/img/bk_qq_group.png" width="250" hegiht="250" align=center />


## BlueKing Community

- [BK-CI](https://github.com/Tencent/bk-ci)：蓝鲸持续集成平台是一个开源的持续集成和持续交付系统，可以轻松将你的研发流程呈现到你面前。
- [BK-BCS](https://github.com/Tencent/bk-bcs)：蓝鲸容器管理平台是以容器技术为基础，为微服务业务提供编排管理的基础服务平台。
- [BK-PaaS](https://github.com/Tencent/bk-PaaS)：蓝鲸PaaS平台是一个开放式的开发平台，让开发者可以方便快捷地创建、开发、部署和管理SaaS应用。
- [BK-SOPS](https://github.com/Tencent/bk-sops)：标准运维（SOPS）是通过可视化的图形界面进行任务流程编排和执行的系统，是蓝鲸体系中一款轻量级的调度编排类SaaS产品。
- [BK-CMDB](https://github.com/Tencent/bk-cmdb)：蓝鲸配置平台是一个面向资产及应用的企业级配置管理平台。

## Contributing

如果你有好的意见或建议，欢迎给我们提 Issues 或 Pull Requests，为蓝鲸开源社区贡献力量。

## License

基于 MIT 协议， 详细请参考[LICENSE](LICENSE.txt)
